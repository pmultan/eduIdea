package sk.revolone.eduidea.viewmodel;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import sk.revolone.eduidea.data.entity.Category;
import sk.revolone.eduidea.utils.Helpers;

/* All view models should extend this one */
/* Should contain minimal data that is needed on most views */

public class BaseViewModel {
	public String appTitle = "EduIdea";
	private String message;
	
	public String getApplicationUrl() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return String.format("%s://%s:%d/%s/",request.getScheme(),  request.getServerName(), request.getServerPort(), request.getContextPath());
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// This is technically not used, rootCategories are accessed through session as session.rootCategories
	@SuppressWarnings("unchecked")
	public List<Category> getRootCategories() {
		if(Helpers.getSession().getAttribute("rootCategories") != null)
		{
			return (List<Category>)Helpers.getSession().getAttribute("rootCategories");
		}
		else return null;
	}
}
