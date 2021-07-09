package com.javaservlet.dao;

import java.util.List;

import com.javaservlet.dao.mapper.IRoleMapper;

public interface IHandleDAO<T> {
	
	List<T> select(String sql, IRoleMapper<T> roleMapper, Object... parameters);
	
	void insertOrUpdate(String sql, Object... parameters);
	
	T selectOne(String sql, IRoleMapper<T> roleMapper, Object... parameters);
}
