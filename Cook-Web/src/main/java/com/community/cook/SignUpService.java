package com.community.cook;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.community.cook.bean.CookUserRequest;
import com.community.cook.bean.StatusResponse;
import com.community.cook.dao.impl.UserDaoImpl;
import com.community.cook.domain.CookUser;
import com.community.cook.domain.CookUserArea;
import com.community.cook.domain.CookUserSpeciality;

@Service
public class SignUpService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SignUpService.class);

	@Autowired
	private  Mapper mapper;

	@Autowired
	private UserDaoImpl userDao;

	@Transactional(readOnly = false)
	public StatusResponse createCookAccount(@RequestBody CookUserRequest cookUser){
		// validate the CookUserRequest 
		//TODO : Add the code for the validation
		CookUser cookUserDomain = getCookUser(cookUser);
		userDao.addUser(cookUserDomain);
		StatusResponse status = new StatusResponse();
		status.setStatusCode("200");
		status.setStatusMsg("Cook Account Got Created");
		return status;

	}

	private CookUser getCookUser(CookUserRequest cookUser){
		CookUser cookUserDomain = mapper.map(cookUser, CookUser.class);
		// Set the Necessary Parameters
		cookUserDomain.setCreatedBy(1);
		cookUserDomain.setModifiedBy(1);
		cookUserDomain.setModifiedDate(new Date(System.currentTimeMillis()));
		cookUserDomain.setCreatedDate(new Date(System.currentTimeMillis()));
		cookUserDomain.setIsCook("Y");
		// Set the relationships 
		List<String> specialities = cookUser.getSpeciality();

		// Set the Cook user speciality
		Set<CookUserSpeciality> cookUserSpecialities = new HashSet<CookUserSpeciality>();
		for(String speciality: specialities){
			CookUserSpeciality cookUserSpeciality = new CookUserSpeciality();
			cookUserSpeciality.setSpecCode(speciality);
			cookUserSpeciality.setCreatedBy(1);
			cookUserSpeciality.setModifiedBy(1);
			cookUserSpeciality.setModifiedDate(new Date(System.currentTimeMillis()));
			cookUserSpeciality.setCreatedDate(new Date(System.currentTimeMillis()));
			cookUserSpeciality.setCookUser(cookUserDomain);
			cookUserSpecialities.add(cookUserSpeciality);
		}
		cookUserDomain.setCookUserSpecialities(cookUserSpecialities);

		List<String> areas = cookUser.getWorkingArea();

		// Set the Cook user speciality
		Set<CookUserArea> cookUserAreas = new HashSet<CookUserArea>();
		for(String cookArea: areas){
			CookUserArea cookUserArea = new CookUserArea();
			cookUserArea.setAreaCode(cookArea);
			cookUserArea.setCreatedBy(1);
			cookUserArea.setModifiedBy(1);
			cookUserArea.setModifiedDate(new Date(System.currentTimeMillis()));
			cookUserArea.setCreatedDate(new Date(System.currentTimeMillis()));
			cookUserArea.setCookUser(cookUserDomain);
			cookUserAreas.add(cookUserArea);
		}
		cookUserDomain.setCookUserAreas(cookUserAreas);
		return cookUserDomain;
	}
}
