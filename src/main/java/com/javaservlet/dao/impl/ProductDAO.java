package com.javaservlet.dao.impl;

import java.util.List;

import com.javaservlet.dao.IProductDAO;
import com.javaservlet.dao.mapper.impl.ProductMapper;
import com.javaservlet.models.ProductModel;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO{

	@Override
	public List<ProductModel> find() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM PRODUCT";
		return select(sql, new ProductMapper());
	}

	@Override
	public void save(ProductModel productModel) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO PRODUCT(ID, NAME, QUANTITY, PRICE, DESCRIPTION, IMAGE, CATEGORY_ID) "
				+ "VALUES(?,?,?,?,?,?,?)";
		insertOrUpdate(sql, productModel.getId(), productModel.getName(), productModel.getQuantity()
		, productModel.getPrice(), productModel.getDescription(), productModel.getImage(), productModel.getCategoryId());
	}

	@Override
	public void updateOne(ProductModel productModel) {
		// TODO Auto-generated method stub
		String sql = "UPDATE PRODUCT SET NAME=?, QUANTITY=?, PRICE=?, DESCRIPTION=?, IMAGE=?, CATEGORY_ID=? "
				+ "WHERE ID=?";
		insertOrUpdate(sql, productModel.getName(), productModel.getQuantity() , productModel.getPrice(), 
		productModel.getDescription(), productModel.getImage(), productModel.getCategoryId(), productModel.getId());
	}

	@Override
	public ProductModel findOne(String parameter) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM PRODUCT WHERE ID = ?";
		return selectOne(sql, new ProductMapper(), parameter);
	}

}
