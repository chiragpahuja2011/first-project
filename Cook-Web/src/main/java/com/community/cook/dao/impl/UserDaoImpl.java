package com.community.cook.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.community.cook.dao.UserDao;
import com.community.cook.domain.CookUser;

@Repository
public class UserDaoImpl extends BaseDaoImpl  implements UserDao{

	@Override
	public void addUser(CookUser cookUser) {
		saveEntity(cookUser);
	}

	@Override
	public CookUser getUser(String emailId, String password) {
		Criteria criteria = getSession().createCriteria(CookUser.class);
		criteria.add(Restrictions.eq(CookUser.EMAILID, emailId));
		criteria.add(Restrictions.eq(CookUser.PASSWORD,password));
		return (CookUser)criteria.uniqueResult();
	}

	@Override
	public CookUser getUserById(long userId) {
		Criteria criteria = getSession().createCriteria(CookUser.class);
		criteria.add(Restrictions.eq(CookUser.USERID, userId));
		return (CookUser)criteria.uniqueResult();
	}
	
}
