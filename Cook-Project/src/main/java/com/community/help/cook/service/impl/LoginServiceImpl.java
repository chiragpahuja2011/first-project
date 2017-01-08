package com.community.help.cook.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.community.help.cook.bean.LoginRequest;
import com.community.help.cook.dao.UserDao;
import com.community.help.cook.domain.CookUser;
import com.community.help.cook.service.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class LoginServiceImpl implements LoginService, AuthenticationProvider {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private ObjectMapper jacksonMapper;

	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public ObjectNode validateLogin(LoginRequest loginRequest) {
		if(validateUserName(loginRequest)){
			CookUser cookUser =	userDao.findByEmailIdAndPassword(loginRequest.getEmailId(), loginRequest.getPassword());
			ObjectNode responseNode = jacksonMapper.createObjectNode();
			if(null != cookUser){
				LOGGER.info("User iS present ");
				responseNode.put("userInfo", cookUser.toString());
			}else{
				LOGGER.info("User Not Present ");
				responseNode.put("error", "User Not Present/ Please Register");
			}
			return responseNode;
		}else{
			LOGGER.info("Invalid Input");
			return null;
		}
	}

	private boolean validateUserName(LoginRequest loginRequest){
		return null != loginRequest && null != loginRequest.getEmailId() && null != loginRequest.getPassword();
	}


	@Override
	public Authentication authenticate(Authentication paramAuthentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = paramAuthentication.getName();
        String password = (String) paramAuthentication.getCredentials();
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmailId(username);
        loginRequest.setPassword(password);
        
        if(validateUserName(loginRequest)){
			CookUser cookUser =	userDao.findByEmailIdAndPassword(loginRequest.getEmailId(), loginRequest.getPassword());
			ObjectNode responseNode = jacksonMapper.createObjectNode();
			if(null != cookUser){
				LOGGER.info("User iS present ");
				responseNode.put("userInfo", cookUser.toString());
				
			}else{
				LOGGER.info("User Not Present ");
                throw new BadCredentialsException("User not found.");
			}
		}else{
			LOGGER.info("Invalid Input");
            throw new BadCredentialsException("Invalid Input");
		}
		
		return null;
	}

	@Override
	public boolean supports(Class<?> paramClass) {
		// TODO Auto-generated method stub
		return false;
	}
}
