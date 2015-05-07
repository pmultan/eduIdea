package sk.revolone.eduidea.init.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import sk.revolone.eduidea.data.dao.CategoryService;
import sk.revolone.eduidea.utils.Helpers;

public class RequestInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private CategoryService categoryService;

	// before the actual handler will be executed
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		if (Helpers.getSession().getAttribute("rootCategories") == null) {
			Helpers.getSession().setAttribute("rootCategories",
					categoryService.findRootCategories());
		}
		
		return true;
	}
}