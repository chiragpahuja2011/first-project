package com.community.help.cook.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.community.help.cook.dao.SearchDao;
import com.community.help.cook.domain.CookUser;

@Repository
public class SearchDaoImpl extends BaseDaoImpl implements SearchDao {

	/*
	 * (non-Javadoc)
	 * @see com.community.cook.dao.SearchDao#getCookResults(java.util.List)
	 */
	@Override
	public List<CookUser> getCookResults(List<String> areas) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(CookUser.class);
		criteria.createAlias(CookUser.COOKUSERAREAS, "cookUserAreas");
		criteria.add(Restrictions.in("cookUserAreas.areaCode", areas));
		@SuppressWarnings("unchecked")
		List<CookUser> cookUsers = (List<CookUser>)criteria.list();
		return cookUsers;
	}

}
