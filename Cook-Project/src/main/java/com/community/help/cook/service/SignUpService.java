package com.community.help.cook.service;

import com.community.help.cook.bean.CookUserRequest;
import com.community.help.cook.bean.StatusResponse;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface SignUpService {
	
	StatusResponse createCookAccount(CookUserRequest cookUser);
	
	ObjectNode loadStaticData();
}
