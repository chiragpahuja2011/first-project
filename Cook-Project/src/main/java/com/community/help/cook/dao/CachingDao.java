package com.community.help.cook.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.CrudRepository;

import com.community.help.cook.domain.Speciality;

public interface CachingDao extends CrudRepository<Speciality, String> {

	/**
	 * Fetch the Speciality Static data from database
	 * @return
	 */
	List<Speciality> fetchAll();

	/**
	 * Fetch the Areas Static data from database
	 * @return
	 */
	Map<String,String> getAreas();

}
