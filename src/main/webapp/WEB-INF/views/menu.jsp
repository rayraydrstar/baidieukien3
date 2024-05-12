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
	<li><a class="active" href="#home">Thực phẩm</a></li>
	<li><a href="#news">Quần áo</a></li>
	<li><a href="#contact">Điện tử</a></li>
	<li><a href="#about">Xe cộ</a></li>
</ul>