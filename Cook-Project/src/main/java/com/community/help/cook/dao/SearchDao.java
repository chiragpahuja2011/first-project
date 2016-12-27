package com.community.help.cook.dao;

import java.util.List;

import com.community.help.cook.domain.CookUser;

public interface SearchDao extends BaseDao{

	/**
	 * This method fetches the cook serving in a area
	 * 
	 * @param areas
	 * @return List of CookUser
	 */
	List<CookUser> getCookResults(List<String> areas);
}
