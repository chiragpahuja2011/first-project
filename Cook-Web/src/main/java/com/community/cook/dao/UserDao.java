package com.community.cook.dao;

import com.community.cook.domain.CookUser;

public interface UserDao {
	
	void addUser(CookUser cookUser);
	
	CookUser getUser(String emailId, String password);
	
}
