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
import org.springframework.transaction.annotation.Transactional;

import com.community.help.cook.bean.CookSearchRequest;
import com.community.help.cook.bean.UserInformationResponse;
import com.community.help.cook.dao.SearchDao;
import com.community.help.cook.domain.CookUser;
import com.community.help.cook.domain.CookUserArea;
import com.community.help.cook.domain.CookUserSpeciality;
import com.community.help.cook.service.CachingService;
import com.community.help.cook.service.SearchService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class SearchServiceImpl implements SearchService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SearchServiceImpl.class);

	
	@Autowired
	private SearchDao searchDao;
	
	@Autowired
	private ObjectMapper jacksonMapper;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Autowired
	private CachingService cachingService;

	/*
	 * (non-Javadoc)
	 * @see com.community.cook.service.SearchService#fetchCookResults(com.community.cook.bean.CookSearchRequest)
	 */
	@Override
	@Transactional(readOnly = true)
	public ObjectNode fetchCookResults(CookSearchRequest cookSearchRequest) {
		ObjectNode responseNode = jacksonMapper.createObjectNode();
		List<CookUser> cookUsers = searchDao.getCookDataByCookUserAreas(cookSearchRequest.getAreas());
		LOGGER.info("Database Query Finishs");
		if(CollectionUtils.isNotEmpty(cookUsers)){
			LOGGER.info("Database Query Finished"+cookUsers.size());
			List<UserInformationResponse> userResponse = new ArrayList<UserInformationResponse>();
			Map<String, String> specData = cachingService.getSpecialities();
			Map<String, String> areaData = cachingService.getAreas();
			// Iterate Over Cook User Response and build the final Response
			for(CookUser cookUser: cookUsers){
				UserInformationResponse userInfoResponse = mapper.map(cookUser, UserInformationResponse.class);
				// set user id manually for now
				//TODO: add it to mapper later
				userInfoResponse.setUserId(cookUser.getUserId());

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
				
				userResponse.add(userInfoResponse);
			}
			responseNode.put("size", userResponse.size());
			responseNode.set("searchResponse", jacksonMapper.valueToTree(userResponse));
		}
		return responseNode;
	}

}
