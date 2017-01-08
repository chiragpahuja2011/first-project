package com.community.help;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.community.help.cook.service.impl.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomAuthenticationProvider loginSerice;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/","/home","/style/**","/bootstrap/**","/js/**","/images/**","/cook-signup","/cook-upload","/cookSignup/loadData","/cookSignup/cook","/help-user","/cook-search","/header","/profile/cook/{\\d}").permitAll()
		.antMatchers(HttpMethod.POST,"/search/cook").permitAll()
		.antMatchers("/cook-profile").hasAuthority(CustomAuthenticationProvider.COOK_USER_ROLE)
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/cook-login").permitAll()
		.defaultSuccessUrl("/cook-profile")
		.and()
		.logout()
		.permitAll();
		;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(loginSerice);
	}
}
