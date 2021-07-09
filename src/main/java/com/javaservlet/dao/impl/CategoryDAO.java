package com.javaservlet.dao.impl;

import java.util.List;

import com.javaservlet.dao.ICategoryDAO;
import com.javaservlet.dao.mapper.impl.CategoryMapper;
import com.javaservlet.models.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{

	@Override
	public List<CategoryModel> find() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM CATEGORY";
		return select(sql, new CategoryMapper());
	}

}
