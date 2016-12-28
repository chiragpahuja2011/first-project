package com.community.help.cook.dao;

import org.springframework.data.repository.CrudRepository;

import com.community.help.cook.domain.Speciality;

public interface SpecialityDao extends CrudRepository<Speciality, String> {
	

//	@Query("select * from c_speciality b")
//	List<Speciality> getData();
}
