package com.community.help.cook.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.help.cook.bean.CookUserRequest;
import com.community.help.cook.bean.StatusResponse;
import com.community.help.cook.dao.UserDao;
import com.community.help.cook.domain.CookUser;
import com.community.help.cook.domain.CookUserArea;
import com.community.help.cook.domain.CookUserSpeciality;
import com.community.help.cook.service.CachingService;
import com.community.help.cook.service.SignUpService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class SignUpServiceImpl implements SignUpService {


	private static final Logger LOGGER = LoggerFactory.getLogger(SignUpServiceImpl.class);

	@Autowired
	private  Mapper mapper;

	@Autowired
	private ObjectMapper jacksonMapper;

	@Autowired
	private CachingService cachingService;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CustomAuthenticationProvider authenticator;


	@Transactional(readOnly = false)
	@Override
	public StatusResponse createCookAccount(CookUserRequest cookUser, HttpServletRequest request) {
		// validate the CookUserRequest 
		//TODO : Add the code for the validation
		CookUser cookUserDomain = getCookUser(cookUser);
		userDao.save(cookUserDomain);
		doAutoLogin(cookUser.getEmailId(), cookUser.getPassword(), request);
		StatusResponse status = new StatusResponse();
		status.setStatusCode("200");
		status.setStatusMsg("Cook Account Got Created");
		return status;
	}

	/***************************************************
	 * On Signup, create auth token for the user
	 *************************************************/
	private void doAutoLogin(String username, String password, HttpServletRequest request) {

	    try {
	        // Must be called from request filtered by Spring Security, otherwise SecurityContextHolder is not updated
	        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
	        token.setDetails(new WebAuthenticationDetails(request));
	        Authentication authentication = authenticator.authenticate(token);
	        LOGGER.debug("Logging in with [{}]", authentication.getPrincipal());
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	    } catch (Exception e) {
	        SecurityContextHolder.getContext().setAuthentication(null);
	        LOGGER.error("Failure in autoLogin", e);
	    }

	}
	
	
	/*******************************************************
	 * Static Data For application
	 *******************************************************/

	@Override
	@Transactional
	public ObjectNode loadStaticData() {
		LOGGER.info("Fetching Static Data");
		ObjectNode outoutNode = jacksonMapper.createObjectNode();
		Map<String, String> specialities = cachingService.getSpecialities();
		Map<String, String> areas = cachingService.getAreas();

		if(MapUtils.isNotEmpty(specialities)){
			List<ObjectNode> specNode = new ArrayList<ObjectNode>();
 			Iterator<Entry<String,String>> it = specialities.entrySet().iterator();
			while (it.hasNext()) {
				ObjectNode node = jacksonMapper.createObjectNode();
				Map.Entry<String, String> pair = (Map.Entry<String, String>)it.next();
				node.put("spec_code", (String)pair.getKey());
				node.put("spec_desc", (String)pair.getValue());
				specNode.add(node);
			}
			outoutNode.put("specData", specNode.toString());
		}


		if(MapUtils.isNotEmpty(areas)){
			List<ObjectNode> areaNode = new ArrayList<ObjectNode>();
			Iterator<Entry<String,String>> it = areas.entrySet().iterator();
			while (it.hasNext()) {
				ObjectNode node = jacksonMapper.createObjectNode();
				Map.Entry<String, String> pair = (Map.Entry<String, String>)it.next();
				node.put("area_code", (String)pair.getKey());
				node.put("area_desc", (String)pair.getValue());
				areaNode.add(node);
			}
			outoutNode.put("areaData", areaNode.toString());
		}
		return outoutNode;
	}
	
	
	/******************************************************
	 * Private Methods
	 ******************************************************/
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
