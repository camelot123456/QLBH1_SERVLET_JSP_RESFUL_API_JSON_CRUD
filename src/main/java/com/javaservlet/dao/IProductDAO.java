package com.javaservlet.dao;

import java.util.List;

import com.javaservlet.models.ProductModel;

public interface IProductDAO {

	List<ProductModel> find();

	void save(ProductModel productModel);

	void updateOne(ProductModel productModel);

	ProductModel findOne(String parameter);
	
}
