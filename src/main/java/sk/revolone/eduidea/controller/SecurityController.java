package sk.revolone.eduidea.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sk.revolone.eduidea.viewmodel.LoginViewModel;
import sk.revolone.eduidea.viewmodel.WipViewModel;

@Controller
public class SecurityController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	
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
	
	@RequestMapping(value = "sign-up")
	public ModelAndView signIn(Model model)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/signupPage");
		
		return (mav);
	}
	
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "user/options")
	public ModelAndView userOptions(Model model)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shared/wipFragment");
		
		WipViewModel wipModel = new WipViewModel("User Options");
		mav.addObject("model", wipModel);
		
		return (mav);
	}
}
