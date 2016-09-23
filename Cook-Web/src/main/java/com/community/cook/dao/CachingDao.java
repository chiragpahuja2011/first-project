package com.community.cook.dao;

import java.util.List;
import java.util.Map;

import com.community.cook.domain.Area;
import com.community.cook.domain.Speciality;

public interface CachingDao {

	/**
	 * Fetch the Speciality Static data from database
	 * @return
	 */
	Map<String,String> getSpecialities();

	/**
	 * Fetch the Areas Static data from database
	 * @return
	 */
	Map<String,String> getAreas();

}
