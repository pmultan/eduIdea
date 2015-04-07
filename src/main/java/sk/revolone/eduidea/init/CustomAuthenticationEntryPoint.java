package sk.revolone.eduidea.init;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.AuthenticationEntryPoint;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException authException) throws IOException, ServletException {

        if (authException != null) {
            // you can check for the spefic exception here and redirect like this
        	String url = request.getContextPath() + "/403";
            response.sendRedirect(url);
        }
    }
}