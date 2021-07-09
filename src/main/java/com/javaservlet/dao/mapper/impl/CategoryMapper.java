package com.javaservlet.dao.mapper.impl;

import java.sql.ResultSet;

import com.javaservlet.dao.mapper.IRoleMapper;
import com.javaservlet.models.CategoryModel;

public class CategoryMapper implements IRoleMapper<CategoryModel>{

	@Override
	public CategoryModel roleMapper(ResultSet rs) {
		// TODO Auto-generated method stub
		CategoryModel category = null;
		try {
			category = new CategoryModel();
			category.setId(rs.getString("ID"));
			category.setName(rs.getString("NAME"));
			category.setImage(rs.getString("IMAGE"));
			category.setParentId(rs.getString("PARENT_ID"));
			return category;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
