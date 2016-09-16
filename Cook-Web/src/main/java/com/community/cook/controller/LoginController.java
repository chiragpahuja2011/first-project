package com.community.cook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.community.cook.bean.LoginRequest;
import com.community.cook.service.LoginService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller(value = "login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	/**
	 * Create the Cook Account in MySql database
	 * @param cookUser
	 * @return StatusResponse
	 */
	@RequestMapping(value ="/validate", method = RequestMethod.POST)
	@ResponseBody
	public ObjectNode validateLogin(@RequestBody LoginRequest loginRequest){
		return loginService.validateLogin(loginRequest);
	}
	
	
	
}
