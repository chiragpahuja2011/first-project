package com.community.cook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.community.cook.SignUpService;
import com.community.cook.bean.CookUserRequest;
import com.community.cook.bean.StatusResponse;
import com.community.cook.dao.impl.UserDaoImpl;
import com.community.cook.domain.CookUser;

@Controller(value = "signUp")
public class SignupController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private SignUpService signUpService;
	
	/**
	 * Create the Cook Account in Elastic Search
	 * @param cookUser
	 * @return StatusResponse
	 */
	@RequestMapping(value ="/cook", method = RequestMethod.POST)
	@ResponseBody
	public StatusResponse createCookAccount(@RequestBody CookUserRequest cookUser){
		LOGGER.info("Cook Creation is started. This is a test logger");
		return signUpService.createCookAccount(cookUser);
		
	}
	
}
