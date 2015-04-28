package sk.revolone.eduidea.controller;

import org.springframework.web.servlet.ModelAndView;

import sk.revolone.eduidea.viewmodel.WipViewModel;

public class BaseController {
	
	protected ModelAndView errorView(String message, Exception e) {
		if(e != null)
		{
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shared/error");
		mav.addObject("message", message);
		return mav;
	}
	
	protected ModelAndView successView(String message) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shared/success");
		mav.addObject("message", message);
		return mav;
	}
	
	protected ModelAndView wipView(String pageTitle) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shared/wipFragment");

		WipViewModel wipModel = new WipViewModel(pageTitle);
		mav.addObject("model", wipModel);

		return (mav);
	}
	protected ModelAndView errorView(String message) {
		return errorView(message, null);
	}
}
