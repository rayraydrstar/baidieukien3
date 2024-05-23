<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="rootpath" />
<div class="main-menu">
	<div class="banner">
		<h1>HỆ THỐNG CHĂN RAU SẠCH</h1>
	</div>

	<div class="horizontal-menu">
		<a href="${rootpath}/">Trang chủ</a> <a href="${rootpath}/">Sản
			phẩm</a> <a href="${rootpath}form">Thêm mớii</a> <a href="about.html">Liên
			hệ</a>
	</div>
</div>

<ul class="vertical-menu">
	<!-- Note: đang ở trang nào thì thêm class = "active" ở thẻ a của trang đó -->
	<li><a class="active" href="${rootpath}sort_by_category?maDanhMuc=1">Thực phẩm</a></li>
	<li><a href="${rootpath}sort_by_category?maDanhMuc=2">Quần áo</a></li>
	<li><a href="${rootpath}sort_by_category?maDanhMuc=3">Điện tử</a></li>
	<li><a href="${rootpath}sort_by_category?maDanhMuc=4">Gia dụng</a></li>
</ul>