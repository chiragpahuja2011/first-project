package com.community.help.cook.dao;

import org.springframework.data.repository.CrudRepository;

import com.community.help.cook.domain.CookUser;

public interface UserDao extends CrudRepository<CookUser, Long> {
	
	/**
	 * Get User information using email id and password
	 * @param emailId
	 * @param password
	 * @return
	 */
	CookUser findByEmailIdAndPassword(String emailId, String password);
	
	/**
	 * Find User by User Id
	 * @param userId
	 * @return
	 */
	CookUser findByUserId(Long userId);
}
