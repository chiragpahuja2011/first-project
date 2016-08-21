package com.community.cook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.community.cook.bean.CookUserRequest;
import com.community.cook.bean.StatusResponse;

@Controller(value = "signUp")
public class SignupController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	
	/**
	 * Create the Cook Account in Elastic Search
	 * @param cookUser
	 * @return
	 */
	@RequestMapping(value ="/cook", method = RequestMethod.POST)
	@ResponseBody
	public StatusResponse createCookAccount(@RequestBody CookUserRequest cookUser){
		LOGGER.info("Cook Creation is started. This is a test logger");
		StatusResponse status = new StatusResponse();
		status.setStatusCode("200");
		status.setStatusMsg("Cook Account Got Created");
		
		return status;
		
	}
	
}
