package com.community.cook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.community.cook.bean.CookSearchRequest;
import com.community.cook.service.SearchService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
@RequestMapping(value = "/search")
public class SearchController {
	
	
	@Autowired
	private SearchService searchService;
	
	/**
	 * This method fetch the cook servicing in the area input by user
	 * 
	 * @param cookSearchRequest
	 * @return
	 */
	@RequestMapping(value = "/")
	@ResponseBody
	public ObjectNode fetchCookResults(@RequestBody CookSearchRequest cookSearchRequest){
		return searchService.fetchCookResults(cookSearchRequest);
	}

}
