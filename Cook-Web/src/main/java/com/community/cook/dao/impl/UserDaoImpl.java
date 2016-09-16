package com.community.cook.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.community.cook.dao.UserDao;
import com.community.cook.domain.CookUser;

@Repository
public class UserDaoImpl extends BaseDaoImpl  implements UserDao{

	@Override
	public void addUser(CookUser cookUser) {
		Session session = getSession();
		session.persist(cookUser);
	}
	
}
