<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/" var="rootpath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${rootpath}resources/style.css">
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="main">
        <!-- Thẻ info từng sản phẩm -->
        <div class="product-list">
            <c:forEach items="${lstSanPham }" var="p">
            	<!-- Đổ dữ liệu ảnh ở đây -->
            <a class="product" href="${rootpath}detail?id=${p.maSanPham}" style="text-decoration: none; color: #00473e;">
                <!-- Đổ dữ liệu ảnh ở đây -->
                <img src="${p.anh}" width="250px" height="auto">
                <!-- Đổ dữ liệu sản phẩm chỗ dưới này -->
                <h3 style="text-decoration: none">${p.tenSanPham}</h3>
                <p style="text-decoration: none">${p.gia}</p>
            </a>
            </c:forEach>
    </div>
</body>	
</html>