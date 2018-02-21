package by.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import by.home.service.UserService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/registration").permitAll()
				.antMatchers("/projects").hasRole("MANAGER")//access("hasRole('ROLE_MANAGER')")//hasAnyRole("MANAGER")
				.antMatchers("/projects/new").hasRole("MANAGER")
				.and().formLogin() 
					.loginPage("/").loginProcessingUrl("/login")
					.usernameParameter("email")
					.passwordParameter("password")
					.defaultSuccessUrl("/projects")
				.and().csrf().disable()
				.exceptionHandling()
				.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/"));
		/*
		 * .and().logout() //logout configuration .logoutUrl("/appLogout")
		 * .logoutSuccessUrl("/") .and().exceptionHandling() //exception
		 * handling configuration .accessDeniedPage("/error");
		 */
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(
				userService) /*.passwordEncoder(passwordEncoder());*/ ;
	}

	/*
	 * @Bean public PasswordEncoder passwordEncoder() { BCryptPasswordEncoder
	 * passwordEncoder = new BCryptPasswordEncoder(); return passwordEncoder; }
	 */
}
