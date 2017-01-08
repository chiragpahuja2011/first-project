package com.community.help.cook.service;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface CookProfileService {

	
	ObjectNode getCookProfileInfo(final Long userId);
	
}
