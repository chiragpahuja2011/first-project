package com.community.cook.dao;

import java.util.Map;

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
