<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DevPhone Hệ thống bán lẻ điện thoại di động</title>
</head>
<body>

	<c:import url="Header.jsp"></c:import>
	<section class="content">
		<div class="col--left">
			<div class="title">CHI TIẾT ĐIỆN THOẠI</div>


			<div class="product">
				<div>
					<img alt="${product.name}" src="${product.source}" width="300">
				</div>
				<div>
					<h2>
						<i class="fa fa-mobile" aria-hidden="true"></i>&nbsp;
						${product.name}
					</h2>
					<h3>
						<i class="fa fa-money" aria-hidden="true"></i>&nbsp;
						${product.price}&#36;
					</h3>
					<p>Mô tả sản phẩm: ${product.description}</p>
					<button class="btn--cart" data-id="${product.id}">Thêm vào
						giỏ hàng</button>
				</div>

			</div>

		</div>


		<div class="col--right">

			<c:set var="name" value="${sessionScope.login.username}" scope="page"></c:set>

			<c:if test="${empty name }">

				<div class="loginLink">
					<a href="MVC?action=login"><i class="fa fa-sign-in"
						aria-hidden="true"></i>&nbsp; Đăng nhập</a> &nbsp;|&nbsp; <a
						href="MVC?action=register"><i class="fa fa-user-plus"
						aria-hidden="true"></i>&nbsp; Đăng ký</a>
				</div>

			</c:if>
			<c:if test="${!empty name }">

				<div class="loginLink">
					<i class="fa fa-user" aria-hidden="true"></i>&nbsp;Chào ${!empty name ? name: "bạn"}
					<strong>&nbsp;|&nbsp;</strong> <a href="MVC?action=dash">Trang
						cá nhân</a>

				</div>

			</c:if>

			<c:import url="Card.jsp"></c:import>

		</div>
	</section>

	<c:import url="Footer.jsp"></c:import>
	
</body>
</html>