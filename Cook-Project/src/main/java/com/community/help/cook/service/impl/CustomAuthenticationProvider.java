package com.community.help.cook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.community.help.cook.dao.UserDao;
import com.community.help.cook.domain.CookUser;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	public static final String COOK_USER_ROLE = "COOK_USER";
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	@Autowired
	private UserDao userDao;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = (String)authentication.getCredentials();
		if(validateUserName(username, password)){
			CookUser cookUser =	userDao.findByEmailIdAndPassword(username, password);
			if(null != cookUser){
				LOGGER.info("User iS present ");
				List<GrantedAuthority> grantedAuths = new ArrayList<>();
				grantedAuths.add(new SimpleGrantedAuthority(COOK_USER_ROLE));
				return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), grantedAuths);
			}else{
				LOGGER.info("User Not Present ");
				return null;
			}
		}else{
			LOGGER.info("Invalid Input");
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
	private boolean validateUserName(final String emailId, final String password){
		return null != emailId && null != password;
	}

}
