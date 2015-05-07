package sk.revolone.eduidea.init.configuration;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import sk.revolone.eduidea.data.dao.CategoryService;

@Configuration
@ComponentScan({ "sk.revolone.eduidea.controller" })
public class ThymeleafConfiguration {

	@Bean
	public TemplateResolver templateResolver() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/views/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setCacheable(false); // TODO: Need to set the switch,
												// so if not in dev mode this
												// will be TRUE !

		return templateResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();

		Set<IDialect> dialects = new HashSet<IDialect>();
		dialects.add(springSecurityDialect());
		templateEngine.setAdditionalDialects(dialects);

		templateEngine.setTemplateResolver(templateResolver());
		return templateEngine;
	}

	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setOrder(1);
		viewResolver.setCharacterEncoding("UTF-8");

		return viewResolver;
	}

	@Bean
	public SpringSecurityDialect springSecurityDialect() {
		SpringSecurityDialect dialect = new SpringSecurityDialect();
		return dialect;
	}
}
