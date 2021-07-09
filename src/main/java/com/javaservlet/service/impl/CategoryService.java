package com.javaservlet.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.javaservlet.dao.ICategoryDAO;
import com.javaservlet.models.CategoryModel;
import com.javaservlet.service.ICategoryService;

public class CategoryService implements ICategoryService{

	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<CategoryModel> find() {
		// TODO Auto-generated method stub
		return categoryDAO.find();
	}

}
