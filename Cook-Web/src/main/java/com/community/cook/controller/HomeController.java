package com.community.cook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {		
		return ("home.html");
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage() {		
		return ("home.html");
	}
	
	@RequestMapping(value = "/cook-search", method = RequestMethod.GET)
	public String cookSearch(){
		return ("cookSearch.html");
	}

	@RequestMapping(value = "/cook-login", method = RequestMethod.GET)
	public String loginPage(){
		return ("login.html");
	}

	@RequestMapping(value = "/help-user", method = RequestMethod.GET)
	public String helpPage(){
		return ("help.html");
	}
	
	@RequestMapping(value = "/cook-signup", method = RequestMethod.GET)
	public String signUp(){
		return ("signUp.html");
	}
	
	@RequestMapping(value = "/cook-upload", method = RequestMethod.GET)
	public String uploadImage(){
		return ("profileUpload.html");
	}
	
}
