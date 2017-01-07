package com.community.help.cook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	public static final String COOK_USER_ROLE = "COOK_USER";

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if(authentication.getName().equals("admin")  && authentication.getCredentials().equals("admin")) {
	        List<GrantedAuthority> grantedAuths = new ArrayList<>();
	        grantedAuths.add(new SimpleGrantedAuthority(COOK_USER_ROLE));
	        return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), grantedAuths);
	    } else {
	        return null;
	    }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
