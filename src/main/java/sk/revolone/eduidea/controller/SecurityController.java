package sk.revolone.eduidea.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sk.revolone.eduidea.data.dao.UserService;
import sk.revolone.eduidea.exception.EntityNotFound;
import sk.revolone.eduidea.exception.UsernameOrEmailTaken;
import sk.revolone.eduidea.viewmodel.SignUpViewModel;
import sk.revolone.eduidea.viewmodel.WipViewModel;

@Controller
public class SecurityController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	public ModelAndView loginFailed(Model model) {
		logger.info("Entering login failed page.");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/loginPage");

		mav.addObject("loginFailed", true);
		return (mav);
	}

	@RequestMapping(value = "/logout-success-url", method = RequestMethod.GET)
	public ModelAndView logoutSuccess(Model model) {
		logger.info("Logout successful.");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/loginPage");

		mav.addObject("loggedOut", true);
		return (mav);
	}

	@RequestMapping(value = "/login-success-url", method = RequestMethod.GET)
	public ModelAndView loginSuccess(Model model) {
		logger.info("Login successful.");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/loginPage");

		mav.addObject("loggedIn", true);
		return (mav);
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView unathorizedAccess(Model model) {
		logger.info("Unauthorized access.");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/loginPage");

		mav.addObject("unathorizedAccess", true);
		return (mav);
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public ModelAndView signUp(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/signupPage");
		mav.addObject("model", new SignUpViewModel());

		return (mav);
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public ModelAndView signUpPost(
			@ModelAttribute("model") @Valid SignUpViewModel model,
			BindingResult bindingResult, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("home/signupPage",
				bindingResult.getModel());
		mav.addObject("model", model);
		if (bindingResult.hasErrors()) {
			return mav;
		}

		try {
			userService.registerUser(model, request);
		} catch (UsernameOrEmailTaken e) {
			mav.addObject("message", "taken");
			return mav;
		}

		return successView("You've been successfully registered ! Please check your e-mail address to activate your account.");
	}

	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "user/options")
	public ModelAndView userOptions(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shared/wipFragment");

		WipViewModel wipModel = new WipViewModel("User Options");
		mav.addObject("model", wipModel);

		return (mav);
	}

	@RequestMapping(value = "/activation", method = RequestMethod.GET)
	public ModelAndView activateUser(@RequestParam("key") UUID key) {
		try {
			userService.activateUser(key);
		} catch (EntityNotFound e) {
			return errorView(
					"User with such activation key does not exist or is already activated",
					e);
		}
		return successView("Your account has been successfully activated. You can now proceed to Log-in.");
	}
}
