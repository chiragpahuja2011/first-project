package com.community.help.cook.service;

import com.community.help.cook.bean.LoginRequest;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface LoginService {

	ObjectNode validateLogin(LoginRequest loginRequest);
}
