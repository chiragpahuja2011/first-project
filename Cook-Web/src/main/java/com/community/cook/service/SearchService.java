package com.community.cook.service;

import com.community.cook.bean.CookSearchRequest;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface SearchService {
	
	ObjectNode fetchCookResults(CookSearchRequest cookSearchRequest);

}
