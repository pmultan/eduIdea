package sk.revolone.eduidea.init.configuration;

import javax.annotation.Resource;
import javax.servlet.FilterRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

import sk.revolone.eduidea.init.CustomAuthenticationEntryPoint;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource(name = "authService")
	private UserDetailsService customUserDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		ReflectionSaltSource rss = new ReflectionSaltSource();
		rss.setUserPropertyToUse("email");
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setSaltSource(rss);
		provider.setUserDetailsService(customUserDetailsService);
		provider.setPasswordEncoder(new Md5PasswordEncoder());

		auth.authenticationProvider(provider);
		auth.userDetailsService(customUserDetailsService).passwordEncoder(
				new Md5PasswordEncoder());
		/*
		 * auth.inMemoryAuthentication().withUser("user").password("password")
		 * .roles("USER").and().withUser("admin").password("password")
		 * .roles("ADMIN", "USER");
		 */
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Set Unicode encoding
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		http.addFilterBefore(filter, CsrfFilter.class);

		http.httpBasic()
				.authenticationEntryPoint(new CustomAuthenticationEntryPoint())
				.and().exceptionHandling().accessDeniedPage("/403").and()
				.formLogin().loginPage("/login")
				.defaultSuccessUrl("/login-success-url")
				.failureUrl("/loginFailed").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/logout-success-url")
				.invalidateHttpSession(true);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}