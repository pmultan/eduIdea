package sk.revolone.eduidea.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sk.revolone.eduidea.data.dao.UserService;
import sk.revolone.eduidea.data.entity.User;
import sk.revolone.eduidea.data.entity.UserLogged;
import sk.revolone.eduidea.exception.EntityNotFound;
import sk.revolone.eduidea.viewmodel.user.EditProfileViewModel;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	protected AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/user/edit-profile", method = RequestMethod.GET)
	public ModelAndView editProfile() {
		String email = ((UserLogged) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal()).getEmail();
		ModelAndView mav = new ModelAndView();
		User user = null;

		try {
			user = userService.findByEmail(email);
		} catch (EntityNotFound e) {
			e.printStackTrace();
			mav.setViewName("shared/error");
			mav.addObject("message",
					"User you are trying to edit was not found");
			return mav;
		}

		mav.setViewName("user/edit-profile");
		mav.addObject("model", new EditProfileViewModel(user, null));
		return mav;
	}

	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/user/edit-profile", method = RequestMethod.POST)
	public ModelAndView submitEditProfile(@Valid User user,
			BindingResult result, Model model, HttpServletRequest request,
			@ModelAttribute("password") String password) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.setViewName("shared/error");
			mav.addObject("message", "Profile changes coould not be saved");
			return mav;
		}

		User loggedUser = null;
		try {
			loggedUser = userService.findByEmail(user.getEmail());
		} catch (EntityNotFound e1) {
			e1.printStackTrace();
			mav.setViewName("shared/error");
			mav.addObject("message",
					"User you are trying to edit was not found");
			return mav;
		}
		PasswordEncoder encoder = new Md5PasswordEncoder();
		String hashedPass = encoder.encodePassword(password, null);

		if (!loggedUser.getPassword().equals(hashedPass)) {
			mav.setViewName("user/edit-profile");
			mav.addObject("model", new EditProfileViewModel(user, "password"));
			return mav;
		}

		try {
			user = userService.updateProfile(user);
		} catch (EntityNotFound e) {
			e.printStackTrace();
			mav.setViewName("shared/error");
			mav.addObject("message",
					"User you are trying to edit was not found");
			return mav;
		}

		// Update user context
		authenticateUserAndSetSession(password, user, request);

		mav.setViewName("user/edit-profile");
		mav.addObject("model", new EditProfileViewModel(user, "ok"));
		return mav;
	}

	private void authenticateUserAndSetSession(String password, User user,
			HttpServletRequest request) {
		String username = user.getEmail();
		UsernamePasswordAuthenticationToken fakeToken = new UsernamePasswordAuthenticationToken(
				username, password);

		// generate session if one doesn't exist
		request.getSession();

		fakeToken.setDetails(new WebAuthenticationDetails(request));
		Authentication authenticatedUser = authenticationManager
				.authenticate(fakeToken);
		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
	}
}
