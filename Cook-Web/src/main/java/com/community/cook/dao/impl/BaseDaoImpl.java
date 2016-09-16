package com.community.cook.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.community.cook.dao.BaseDao;

@Repository
public class BaseDaoImpl  implements BaseDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public <T> List<T> getData(Class<T> type) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(type);
		List<T> returnList = criteria.list();
		return returnList;
	}
	
}
