package com.community.cook.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.cook.bean.LoginRequest;
import com.community.cook.bean.StatusResponse;
import com.community.cook.controller.LoginController;
import com.community.cook.dao.impl.UserDaoImpl;
import com.community.cook.domain.CookUser;
import com.community.cook.service.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private UserDaoImpl userDao;

	@Autowired
	private ObjectMapper jacksonMapper;

	@Override
	@Transactional
	public ObjectNode validateLogin(LoginRequest loginRequest) {
		if(validateUserName(loginRequest)){
			CookUser cookUser =	userDao.getUser(loginRequest.getEmailId(), loginRequest.getPassword());
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
}
