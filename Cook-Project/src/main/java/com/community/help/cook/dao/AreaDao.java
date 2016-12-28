package com.community.help.cook.dao;

import org.springframework.data.repository.CrudRepository;

import com.community.help.cook.domain.Area;

public interface AreaDao extends CrudRepository<Area, String> {

	
//	@Query("select * from c_area b")
//	List<Area> getAreas();
	
}
