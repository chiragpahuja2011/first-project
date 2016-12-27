package com.community.help.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {		
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome() {		
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/cook-search", method = RequestMethod.GET)
	public ModelAndView cookSearch(){
		return new ModelAndView("cookSearch");
	}

	@RequestMapping(value = "/cook-login", method = RequestMethod.GET)
	public ModelAndView loginPage(){
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/help-user", method = RequestMethod.GET)
	public ModelAndView helpPage(){
		return new ModelAndView("help");
	}
	
	@RequestMapping(value = "/cook-signup", method = RequestMethod.GET)
	public ModelAndView signUp(){
		return new ModelAndView("signUp");
	}
	
	@RequestMapping(value = "/cook-upload", method = RequestMethod.GET)
	public ModelAndView uploadImage(){
		return new ModelAndView("profileUpload");
	}

}
