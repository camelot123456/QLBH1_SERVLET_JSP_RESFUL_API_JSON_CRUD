package com.javaservlet.service;

import java.util.List;

import com.javaservlet.models.ProductModel;

public interface IProductService {
	
	List<ProductModel> find();

	void save(ProductModel productModel);

	void updateOne(ProductModel productModel);

	ProductModel findOne(String parameter);
	
}
