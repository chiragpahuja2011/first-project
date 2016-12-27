package com.community.help.cook.dao;

import com.community.help.cook.domain.CookUser;

public interface UserDao {
	
	void addUser(CookUser cookUser);
	
	CookUser getUser(String emailId, String password);
	
	CookUser getUserById(long userId);
	
}
