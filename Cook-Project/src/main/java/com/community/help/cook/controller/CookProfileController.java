package com.community.help.cook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.community.help.cook.service.CookProfileService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
@RequestMapping(value = "/profile")
public class CookProfileController {
	
	@Autowired
	private CookProfileService cookProfileService;
	
	
	@RequestMapping(value ="/cook/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public ObjectNode validateLogin(@PathVariable(value ="userId") Long userId){
		return cookProfileService.getCookProfileInfo(userId);
	}


}
