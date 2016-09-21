package com.community.cook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.cook.bean.CookSearchRequest;
import com.community.cook.bean.UserInformationResponse;
import com.community.cook.dao.SearchDao;
import com.community.cook.domain.CookUser;
import com.community.cook.service.SearchService;
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

	/*
	 * (non-Javadoc)
	 * @see com.community.cook.service.SearchService#fetchCookResults(com.community.cook.bean.CookSearchRequest)
	 */
	@Override
	@Transactional(readOnly = true)
	public ObjectNode fetchCookResults(CookSearchRequest cookSearchRequest) {
		ObjectNode responseNode = jacksonMapper.createObjectNode();
		List<CookUser> cookUsers = searchDao.getCookResults(cookSearchRequest.getAreas());
		LOGGER.info("Database Query Finishs");
		if(CollectionUtils.isNotEmpty(cookUsers)){
			LOGGER.info("Database Query Finished"+cookUsers.size());
			List<UserInformationResponse> userResponse = new ArrayList<UserInformationResponse>();
			// Iterate Over Cook User Response and build the final Response
			for(CookUser cookUser: cookUsers){
				UserInformationResponse userInfoResponse = mapper.map(cookUser, UserInformationResponse.class);
				
				if(CollectionUtils.isNotEmpty(cookUser.getCookUserSpecialities())){
					
				}
				
				userResponse.add(userInfoResponse);
			}
			
			
		}
		return null;
	}

}
