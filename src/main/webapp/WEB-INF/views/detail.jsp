<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="rootpath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${rootpath}resources/style.css">
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="main">
		<!-- Thẻ info từng sản phẩm -->
		<div class="product-detail">
        <img src="${sp.anh}" alt="" width="350px" height="auto">
        <div class="description">
            <h2>${sp.tenSanPham}</h2>
            <p>Giá: ${sp.gia} VND</p>
            <p>Số lượng: ${sp.soLuong }</p>
            <p>Mô tả: ${sp.moTa }</p>
            <p>Danh mục: ${sp.danhMuc.tenDanhMuc }</p>
            <div style="display: flex;">
                <a href="${rootpath}update?id=${sp.maSanPham}" class="btn update">Chỉnh sửa</a>
                <a href="${rootpath}delete?id=${sp.maSanPham}" class="btn delete">Xóa</a>
            </div>
        </div>
    </div>
</body>
</html>