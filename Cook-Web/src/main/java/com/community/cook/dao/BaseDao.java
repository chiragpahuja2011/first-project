package com.community.cook.dao;

import java.util.List;

public interface BaseDao {

	<T> List<T> getData(Class<T> type);
}
