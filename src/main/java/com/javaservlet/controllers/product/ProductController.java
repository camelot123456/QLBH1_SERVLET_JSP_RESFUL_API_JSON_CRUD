package com.javaservlet.controllers.product;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaservlet.dao.IProductDAO;
import com.javaservlet.service.ICategoryService;
import com.javaservlet.service.IProductService;

@WebServlet(urlPatterns= {"/product"})
public class ProductController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private IProductService productService;
	
	@Inject
	private ICategoryService categoryService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("products", productService.find());
		req.setAttribute("categorys", categoryService.find());
		String action = req.getParameter("action");
		String path = "";
		if(action == null) {
			path = "/views/product/product/display.jsp";
		} else if(action.equals("add")) {
			path = "/views/product/product/insert.jsp";
		} else if(action.equals("edit")) {
			req.setAttribute("productId", req.getParameter("id"));
			req.setAttribute("product",productService.findOne(req.getParameter("id")));
			path = "/views/product/product/update.jsp";
		}
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
}
