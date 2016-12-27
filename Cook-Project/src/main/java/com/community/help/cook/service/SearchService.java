package com.community.help.cook.service;

import com.community.help.cook.bean.CookSearchRequest;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface SearchService {
	
	ObjectNode fetchCookResults(CookSearchRequest cookSearchRequest);

}
