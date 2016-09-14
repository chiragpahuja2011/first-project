package com.community.cook.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.community.cook.dao.UserDao;
import com.community.cook.domain.CookUser;

@Repository
public class UserDaoImpl  implements UserDao{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addUser(CookUser cookUser) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(cookUser);
		System.out.println("User saved successfully");
		
	}

}
