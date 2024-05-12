<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<sp:url value="/" var="rootpath" />
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
		<div class="product-form">
			<spf:form action="${rootpath}/insert" method="post" modelAttribute="sp">
				<label for="name">Tên sản phẩm</label> 
				<spf:input path="tenSanPham" type="text" id="name" size="50" />
				<spf:errors path="tenSanPham" cssClass="error"/>
				<br> 
				<label for="price">Giá sản phẩm</label> 
				<spf:input type="number" path="gia" id="price" size="50" />
				<spf:errors path="gia" cssClass="error"/>
				<br> 
				<label for="price">Số lượng</label> 
				<spf:input type="number" path="soLuong" id="price" size="50" />
				<spf:errors path="soLuong" cssClass="error"/>
				<br> 
				<label for="name">Mô tả</label> 
				<spf:input path="moTa" type="text" id="name" size="50" />
				<spf:errors path="moTa" cssClass="error"/>
				<br> 
				<label for="name">Danh mục</label> 
				<spf:select path="danhMuc.maDanhMuc">
					<spf:options items="${lstDM}" itemLabel="tenDanhMuc" itemValue="maDanhMuc" />
				</spf:select>
				<br>
				<label for="img">Link ảnh sản phẩm</label> 
				<spf:input type="text" path="anh" id="img" size="50s" /> 
				<spf:errors path="anh" cssClass="error"/>
				<br>
			
				<button type="submit" class="btn update">Submit</button>
			</spf:form>
			${msgErr} ${msgOk}
		</div>
	</div>
</body>
</html>