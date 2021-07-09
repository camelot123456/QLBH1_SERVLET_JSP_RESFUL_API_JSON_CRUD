package com.javaservlet.dao;

import java.util.List;

import com.javaservlet.models.CategoryModel;

public interface ICategoryDAO {
	
	List<CategoryModel> find();
	
}
