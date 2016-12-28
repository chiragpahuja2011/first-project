package com.community.help.cook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.community.help.cook.domain.CookUser;

public interface SearchDao extends Repository<CookUser, Long>{

	/**
	 * This method fetches the cook serving in a area
	 * 
	 * @param areas
	 * @return List of CookUser
	 */
	@Query("select a from CookUser a inner join a.cookUserAreas b where a.userId = b.cookUser and b.areaCode in (:cookUserAreas)")
	List<CookUser> getCookDataByCookUserAreas(List<String> cookUserAreas);
}
