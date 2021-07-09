<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/views/taglib.jsp" %>
<form>
	<div class="mt-4">
		<a class="btn-link" href="/product?action=add">Thêm sản phẩm</a>
	</div>
	<table class="table mt-4">
	  <thead>
	    <tr>
	      <th scope="col"><input type="checkbox" class="" id="checkbox_${product.id}"></th>
	      <th scope="col">#</th>
	      <th scope="col">ID</th>
	      <th scope="col">Hình ảnh</th>
	      <th scope="col">Tên</th>
	      <th scope="col">Số lượng</th>
	      <th scope="col">Đơn giá</th>
	      <th scope="col" class="text-center">Công cụ</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach varStatus="loop" var="product" items="${products}">
	    	<tr>
	    	  <td><input type="checkbox" class="" id="checkbox_${product.id}"></td>
		      <td scope="row">${loop.count}</td>
		      <td>${product.id}</td>
		      <td><img src="${product.image}" style="width: 100px;"/></td>
		      <td>${product.name}</td>
		      <td>${product.quantity}</td>
		      <td>${product.price}</td>
		      <td>
		      	<a class="btn-link" href="/product?action=detail&id=${product.id}">Chi tiết</a> | 
		      	<a class="btn-link" href="/product?action=edit&id=${product.id}">Sửa</a> | 
		      	<a class="btn-link" href="/product?action=delete&id=${product.id}">Xóa</a>
		      </td>
		    </tr>
	    </c:forEach>
	  </tbody>
	</table>
</form>