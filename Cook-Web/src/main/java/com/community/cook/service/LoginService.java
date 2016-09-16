package com.community.cook.service;

import com.community.cook.bean.LoginRequest;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface LoginService {

	ObjectNode validateLogin(LoginRequest loginRequest);
}
