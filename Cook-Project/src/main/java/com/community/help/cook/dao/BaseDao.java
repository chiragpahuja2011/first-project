package com.community.help.cook.dao;

import java.util.List;

public interface BaseDao {

	<T> List<T> getData(Class<T> type);
	
	<T> void saveEntity(Object object);
	
}
