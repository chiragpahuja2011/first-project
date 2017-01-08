package com.community.help.cook.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.help.cook.bean.UserInformationResponse;
import com.community.help.cook.dao.UserDao;
import com.community.help.cook.domain.CookUser;
import com.community.help.cook.domain.CookUserArea;
import com.community.help.cook.domain.CookUserSpeciality;
import com.community.help.cook.service.CachingService;
import com.community.help.cook.service.CookProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class CookProfileServiceImpl implements CookProfileService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CookProfileServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ObjectMapper jacksonObjectMapper;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Autowired
	private CachingService cachingService;

	
	@Override
	public ObjectNode getCookProfileInfo(Long userId) {
		// TODO Auto-generated method stub
		CookUser cookUser = userDao.findByUserId(userId);
		
		if(null != cookUser) {
			ObjectNode response = jacksonObjectMapper.createObjectNode();
			Map<String, String> specData = cachingService.getSpecialities();
			Map<String, String> areaData = cachingService.getAreas();
			
			UserInformationResponse userInfoResponse = mapper.map(cookUser, UserInformationResponse.class);
			
			// Set the Speciality Data for the Cook
			if(CollectionUtils.isNotEmpty(cookUser.getCookUserSpecialities())){
				List<String> specialites = new ArrayList<String>();

				for(CookUserSpeciality cookUserSpeciality: cookUser.getCookUserSpecialities()){
					specialites.add(specData.get(cookUserSpeciality.getSpecCode()));
				}
				userInfoResponse.setSpeciality(specialites);
			}
		
			// Set the area Data for the cook
			
			if(CollectionUtils.isNotEmpty(cookUser.getCookUserAreas())){
				List<String> areas = new ArrayList<String>();

				for(CookUserArea cookUserArea: cookUser.getCookUserAreas()){
					areas.add(areaData.get(cookUserArea.getAreaCode()));
				}
				userInfoResponse.setWorkingArea(areas);
			}
			
			response.put("profileResponse", jacksonObjectMapper.valueToTree(userInfoResponse));
			return response;
			
		}else{
			LOGGER.error("User not found");
			return null;
		}
	}

}
