package com.javaservlet.dao.mapper;

import java.sql.ResultSet;

public interface IRoleMapper<T>{
	
	T roleMapper(ResultSet rs);
	
}
