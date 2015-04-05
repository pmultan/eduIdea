package sk.revolone.eduidea.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sk.revolone.eduidea.data.dao.NewsService;
import sk.revolone.eduidea.viewmodel.NewsViewModel;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private NewsService newsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/home");

		NewsViewModel newsViewModel = new NewsViewModel();
		newsViewModel.fillWithBasicValues(newsService, locale);

		mav.addObject("newsViewModel", newsViewModel);

		return (mav);
	}

	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	public ModelAndView loginFailed(Model model) {
		logger.info("Entering login failed page.");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/loginPage");

		mav.addObject("loginFailed", true);
		return (mav);
	}
	
/*	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
 
		ModelAndView mav = new ModelAndView();
		if (error != null) {
			mav.addObject("error", "Invalid username and password!");
		}
 
		if (logout != null) {
			mav.addObject("msg", "You've been logged out successfully.");
		}
		mav.setViewName("home/loginPage");

		return (mav);
	}*/

	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/userHome", method = RequestMethod.GET)
	public ModelAndView userHome(Model model) {
		logger.info("Entering login page.");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/userHome");

		return (mav);
	}
	
	@RequestMapping(value = "/logout-success-url", method = RequestMethod.GET)
	public ModelAndView logoutSuccess(Model model) {
		logger.info("Logout successful");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/loginPage");

		mav.addObject("loggedOut", true);
		return (mav);
	}

}
