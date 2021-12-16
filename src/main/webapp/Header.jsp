<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Header</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/style.css" type="text/css" />
<!-- Load an icon library to show a hamburger menu (bars) on small screens -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Asset/css/font-awesome.min.css">
</head>
<body>
	<header>
		<nav>
			<div class="nav__logo">
				<a href="${pageContext.request.contextPath}/MVC?action=home"><img src="${pageContext.request.contextPath}/Asset/image/logo.png" alt="logo"></a>
			</div>
			<div >
				<form action="SearchShow" method="get"   class="nav__search">
					<i class="fa fa-search nav__search--icon" aria-hidden="true"></i>
					 <input
						type="search" class="nav__search--input" id="searchPhone"
						name="search" placeholder="Tìm kiếm..." />
					
				</form>

			</div>

			<ul class="nav__list">
				<!-- USING CHECKBOX HACK -->
				<input type="checkbox" id="checkbox_toggle" />
				<label for="checkbox_toggle" class="hamburger">&#9776;</label>
				
				<!-- NAVIGATION MENUS -->
				
				<div class="nav__list__menu">
					<li><a href="${pageContext.request.contextPath}/MVC?action=home">Trang chủ</a></li>
					<li><a href="#">Sản phẩm</a></li>
					<li><a href="#">Dịch vụ</a></li>
					<li><a href="#">Bảo hành</a></li>
				</div>

			</ul>

		</nav>

	</header>
	<script src="${pageContext.request.contextPath}/Asset/js/header.js"></script>
</body>
</html>