package sk.revolone.eduidea.viewmodel;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/* All view models should extend this one */
/* Should contain minimal data that is needed on most views */

public class BaseViewModel {

	public String appTitle = "EduIdea";
	private String applicationUrl;
	
	public String getApplicationUrl() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return String.format("%s://%s:%d/%s/",request.getScheme(),  request.getServerName(), request.getServerPort(), request.getContextPath());
	}
}
