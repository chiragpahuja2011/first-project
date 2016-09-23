package com.community.cook.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.Criteria;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.community.cook.dao.CachingDao;
import com.community.cook.domain.Area;
import com.community.cook.domain.Speciality;

@Repository
public class CachingDaoImpl extends BaseDaoImpl  implements CachingDao {

	@Cacheable(value = "speciality")
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> getSpecialities() {
		Map<String, String> specialityMap = new HashMap<String, String>();
		Criteria criteria = getSession().createCriteria(Speciality.class);
		List<Speciality>  specs = (List<Speciality>) criteria.list();
		if(CollectionUtils.isNotEmpty(specs)){
			for(Speciality spec: specs ){
				specialityMap.put(spec.getSpecCode(),spec.getSpecDesc());
			}
		}
		return specialityMap;
	}

	@Cacheable(value = "areas")
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> getAreas() {
		Map<String, String> areaMap = new HashMap<String, String>();

		Criteria criteria = getSession().createCriteria(Area.class);
		List<Area> areas = (List<Area>)criteria.list();
		if(CollectionUtils.isNotEmpty(areas)){
			for(Area area: areas ){
				areaMap.put(area.getAreaCode(),area.getAreaDesc());
			}
		}
		return areaMap;
	}

}
