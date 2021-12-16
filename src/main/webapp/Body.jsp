<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<body>
	<main>
		<section class="banner">
			<!-- Slideshow container -->
			<div class="slideshow-container">

				<!-- Full-width images with number and caption text -->
				<div class="mySlides fade">

					<img src="Asset/image/web-fold-filp-01.png" style="width: 100%">

				</div>

				<div class="mySlides fade">

					<img src="Asset/image/iphone-13.png" style="width: 100%">

				</div>

				<div class="mySlides fade">

					<img src="Asset/image/hotsale-xiaomi.png" style="width: 100%">

				</div>

				<!-- Next and previous buttons -->
				<a class="prev" onclick="plusSlides(-1)">&#10094;</a> <a
					class="next" onclick="plusSlides(1)">&#10095;</a>
				<!-- The dots/circles -->
				<div class="dots">
					<span class="dot" onclick="currentSlide(1)"></span> <span
						class="dot" onclick="currentSlide(2)"></span> <span class="dot"
						onclick="currentSlide(3)"></span>
				</div>
			</div>

		</section>
		<section class="content">
			<div class="col--left">
				<div class="title">ĐIỆN THOẠI NỔI BẬT</div>
				<div class="products">
					<!-- 				Show the list of product -->
					<jsp:useBean id="listProduct" class="bean.ShowListProduct"
						scope="page"></jsp:useBean>
					<c:if test="${param.page != null }">
						<jsp:setProperty name="listProduct" property="page" />
					</c:if>
					<c:forEach var="product" items="${listProduct.listProducts}">

						<div class="item">
							<a
								href="${pageContext.request.contextPath}/ProductDetail?id=${product.id}">
								<img alt="${product.name}" src="${product.source}">
								<h2>
									<i class="fa fa-mobile" aria-hidden="true"></i>&nbsp;
									${product.name}
								</h2>
								<h3>
									<i class="fa fa-money" aria-hidden="true"></i>&nbsp;
									${product.price}&#36;
								</h3>
							</a>
						</div>

					</c:forEach>


				</div>
				<div class="pageNumber">
					<c:forEach var="pageNum" begin="1" end="${listProduct.numberPage}"
						step="1">
						<a href="<c:url value="/Home.jsp?page=${pageNum}"/>">${pageNum}</a>
					</c:forEach>
				</div>

			</div>


			<div class="col--right">
				<c:set var="name" value="${sessionScope.login.username}"
					scope="page"></c:set>

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

	</main>
	<script src="${pageContext.request.contextPath}/Asset/js/body.js"></script>

</body>



</html>