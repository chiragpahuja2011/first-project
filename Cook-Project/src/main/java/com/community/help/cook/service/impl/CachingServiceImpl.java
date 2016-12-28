package com.community.help.cook.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.community.help.cook.dao.AreaDao;
import com.community.help.cook.dao.SpecialityDao;
import com.community.help.cook.domain.Area;
import com.community.help.cook.domain.Speciality;
import com.community.help.cook.service.CachingService;

@Service
public class CachingServiceImpl implements CachingService {
	
	
	@Autowired
	private SpecialityDao specialityDao;
	
	@Autowired
	private AreaDao areaDao;
	
	@Cacheable(value = "speciality")
	@Override
	public Map<String, String> getSpecialities() {
		Map<String, String> specialityMap = new HashMap<String, String>();
		List<Speciality>  specs = (List<Speciality> )specialityDao.findAll();
		if(CollectionUtils.isNotEmpty(specs)){
			for(Speciality spec: specs ){
				specialityMap.put(spec.getSpecCode(),spec.getSpecDesc());
			}
		}
		return specialityMap;
	}
	
	@Cacheable(value = "areas")
	@Override
	public Map<String, String> getAreas() {
		Map<String, String> areaMap = new HashMap<String, String>();

		List<Area> areas = (List<Area>)areaDao.findAll();
		if(CollectionUtils.isNotEmpty(areas)){
			for(Area area: areas ){
				areaMap.put(area.getAreaCode(),area.getAreaDesc());
			}
		}
		return areaMap;
	}

}
