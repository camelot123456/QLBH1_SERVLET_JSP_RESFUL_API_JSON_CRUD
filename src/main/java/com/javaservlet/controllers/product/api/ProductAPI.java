package com.javaservlet.controllers.product.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaservlet.models.ProductModel;
import com.javaservlet.service.IProductService;
import com.javaservlet.utils.HttpUtil;

@WebServlet(urlPatterns= {"/api-product"})
public class ProductAPI extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProductService productService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ProductModel productModel = HttpUtil.of(req.getReader()).toModel(ProductModel.class);
		productService.save(productModel);
		resp.sendRedirect(req.getContextPath() + "/product");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ProductModel productModel = HttpUtil.of(req.getReader()).toModel(ProductModel.class);
		productService.updateOne(productModel);
		resp.sendRedirect(req.getContextPath() + "/product");
	}
	
}
