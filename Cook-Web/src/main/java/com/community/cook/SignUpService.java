package com.community.cook;

import java.sql.Date;

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
		CookUser cookUserDomain = mapper.map(cookUser, CookUser.class);
		cookUserDomain.setGender("M");
		cookUserDomain.setCreatedBy(1);
		cookUserDomain.setModifiedBy(1);
		cookUserDomain.setModifiedDate(new Date(System.currentTimeMillis()));
		cookUserDomain.setCreatedDate(new Date(System.currentTimeMillis()));
		cookUserDomain.setIsCook("Y");
		userDao.addUser(cookUserDomain);
		StatusResponse status = new StatusResponse();
		status.setStatusCode("200");
		status.setStatusMsg("Cook Account Got Created");
		return status;
		
	}
}
