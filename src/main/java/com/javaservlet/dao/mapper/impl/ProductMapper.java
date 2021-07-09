package com.javaservlet.dao.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaservlet.dao.mapper.IRoleMapper;
import com.javaservlet.models.ProductModel;

public class ProductMapper implements IRoleMapper<ProductModel>{
	
	@Override
	public ProductModel roleMapper(ResultSet rs) {
		// TODO Auto-generated method stub
		ProductModel product = null;
		try {
			product = new ProductModel();
			product.setId(rs.getString("ID"));
			product.setName(rs.getString("NAME"));
			product.setQuantity(rs.getInt("QUANTITY"));
			product.setPrice(rs.getDouble("PRICE"));
			product.setDescription(rs.getString("DESCRIPTION"));
			product.setImage(rs.getString("IMAGE"));
			product.setCategoryId(rs.getString("CATEGORY_ID"));
			return product;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
