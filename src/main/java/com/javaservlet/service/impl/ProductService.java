package com.javaservlet.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.javaservlet.dao.IProductDAO;
import com.javaservlet.models.ProductModel;
import com.javaservlet.service.IProductService;

public class ProductService implements IProductService{

	@Inject
	private IProductDAO productDAO;
	
	@Override
	public List<ProductModel> find() {
		// TODO Auto-generated method stub
		return productDAO.find();
	}

	@Override
	public void save(ProductModel productModel) {
		// TODO Auto-generated method stub
		productDAO.save(productModel);
	}

	@Override
	public void updateOne(ProductModel productModel) {
		// TODO Auto-generated method stub
		productDAO.updateOne(productModel);
	}

	@Override
	public ProductModel findOne(String parameter) {
		// TODO Auto-generated method stub
		return productDAO.findOne(parameter);
	}

}
