<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/views/taglib.jsp" %>
<title>Cập nhập sản phẩm</title>
<div class="container mt-4">
	<form action="" id="formSubmit">
		<div class="form-group">
		    <label for="categoryId">Danh mục cha</label>
		    <select class="form-control" id="categoryId" name="categoryId">
		    	<option value="">Chọn danh mục</option>
		    	<c:forEach var="category" items="${categorys}">
			    	<option value="${category.id}">${category.name}</option>
		    	</c:forEach>
		    </select>
		</div>
		
		<div class="form-group">
		    <label for="productId">Mã sản phẩm</label>
		    <input type="text" class="form-control" id="productId" value="${productId}" disabled="disabled">
		    <input type="hidden" id="id" name="id" value="${productId}">
		</div>
		
		<div class="form-group">
		    <label for="name">Tên sản phẩm</label>
		    <input type="text" class="form-control" id="name" name="name" value="${product.name}">
		</div>
		
		<div class="form-group">
		    <label for="quantity">Số lượng</label>
		    <input type="text" class="form-control" id="quantity" name="quantity" value="${product.quantity}">
		</div>
		
		<div class="form-group">
		    <label for="price">Đơn giá</label>
		    <input type="text" class="form-control" id="price" name="price" value="${product.price}">
		</div>
		
		<div class="form-group">
		    <label for="image">Hình ảnh</label>
		    <input type="text" class="form-control" id="image" name="image" value="${product.image}">
		</div>
		
		<div class="form-group">
		    <label for="description">Mô tả sản phẩm</label>
		    <input type="text" class="form-control" id="description" name="description" value="${product.description}">
		</div>
		
		<button type="submit" class="btn btn-primary mt-4 btn-update">Lưu lại</button>
	</form>
</div>
<script>
	var $ = document.querySelector.bind(document);
	var $$ = document.querySelectorAll.bind(document);
	
	var btnUpdate = $('.btn-update');
	
	var formData = $('#formSubmit');
	
	function add(a) {
		
		fetch('http://localhost:8080/api-product',{
			method:'PUT',
			headers:{
				'Content-Type': 'application/json',
				'Accept': 'application/json'
			},
			body: JSON.stringify(a)
		})
		 	.then((response) => response.json())
		 	.then((messages) => {console.log("messages");});
	}
	
	btnUpdate.addEventListener('click',(e)=>{
		e.preventDefault();
		
		var elements = formData.elements;
		
	    var form = new FormData(formData);
	    const categoryId = form.get('categoryId');
	    const id = form.get('id');
	    const name = form.get('name');
	    const quantity = form.get('quantity');
	    const price = form.get('price');
	    const description = form.get('description');
	    const image = form.get('image');
		
	    var data={categoryId, id, name, quantity, price, description, image};
		add(data);
	});
</script>