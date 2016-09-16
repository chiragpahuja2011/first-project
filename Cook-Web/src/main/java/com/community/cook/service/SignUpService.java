package com.community.cook.service;

import com.community.cook.bean.CookUserRequest;
import com.community.cook.bean.StatusResponse;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface SignUpService {
	
	StatusResponse createCookAccount(CookUserRequest cookUser);
	
	ObjectNode loadStaticData();
}
