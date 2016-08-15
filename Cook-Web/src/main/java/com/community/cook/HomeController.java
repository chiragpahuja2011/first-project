package com.community.cook;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {		
		System.out.println("Hi ");
		return ("home.html");
	}
	
	@RequestMapping(value = "/cook", method = RequestMethod.GET)
	public String homePage() {		
		System.out.println("Hi ");
		return ("home.html");
	}
	
	@RequestMapping(value = "/cookSearch", method = RequestMethod.GET)
	public String cookSearch(){
		return ("cookSearch.html");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(){
		return ("login.html");
	}

	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public String helpPage(){
		return ("help.html");
	}

	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public List<UserInformation> getUserInfo(){
		List<UserInformation> userInfos = new ArrayList<UserInformation>();
		UserInformation user1 = new UserInformation();
		user1.setFirstName("Chirag");
		user1.setLastName("Pahuja");
		user1.setImageURL("http://abc.com");
		List<String> speciality = new ArrayList<String>();
		speciality.add("Nopth");
		speciality.add("South");
		user1.setSpeciality(speciality);
		userInfos.add(user1);

		UserInformation user2 = new UserInformation();
		user2.setFirstName("Harish");
		user2.setLastName("Chauhan");
		user2.setImageURL("http://abc.com");
		user2.setSpeciality(speciality);
		userInfos.add(user2);
		return userInfos;

	}


}

