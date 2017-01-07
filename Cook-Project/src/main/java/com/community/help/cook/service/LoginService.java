package com.community.help.cook.service;

import org.springframework.security.authentication.AuthenticationProvider;

import com.community.help.cook.bean.LoginRequest;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface LoginService extends AuthenticationProvider {

	ObjectNode validateLogin(LoginRequest loginRequest);
}
