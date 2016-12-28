package com.community.help.cook.service;

import java.util.Map;

public interface CachingService {
	
	/**
	 * Fetch the Speciality static data table
	 * @return
	 */
	Map<String, String> getSpecialities();
	
	/**
	 * Fetch the Area static data table
	 * @return
	 */
	Map<String, String> getAreas();

}
