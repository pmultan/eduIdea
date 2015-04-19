package sk.revolone.eduidea.controller;

import org.springframework.web.servlet.ModelAndView;

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
	
	protected ModelAndView errorView(String message) {
		return errorView(message, null);
	}
}
