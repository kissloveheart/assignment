<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<c:import url="/ListOrdered"></c:import>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>DashBoard user</title>
<link rel="stylesheet" href="<c:url value="/Asset/css/style.css" />"
	type="text/css" />
<!-- Load an icon library to show a hamburger menu (bars) on small screens -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Asset/css/font-awesome.min.css">
</head>
<body>

	<c:set var="name" value="${sessionScope.login.username}" scope="page"></c:set>
	<div class="sideNav">
		<a href="${pageContext.request.contextPath}/MVC?action=home"><img
			src="${pageContext.request.contextPath}/Asset/image/logo.png"
			alt="logo"></a>
		<ul>
			<li><p>
					<i class="fa fa-user" aria-hidden="true"></i>&nbsp;Chào ${!empty name ? name: "bạn"}
				</p></li>
			<li><a href="<%=request.getContextPath()%>/MVC?action=home"><i
					class="fa fa-home" aria-hidden="true"></i>&nbsp;Trang chủ</a></li>
			<li><a href="<%=request.getContextPath()%>/MVC?action=logout"><i
					class="fa fa-sign-out" aria-hidden="true"></i>&nbsp;Đăng xuất </a></li>
		</ul>
	</div>


		<div class="overView">
			<div class="dashBoard">
				<h2>DASHBOARD</h2>
				<section class="content">
					<div class="dash--left">
						<div class="title">DANH SÁCH ĐƠN HÀNG</div>
						<div class="order">

							<c:set var="list" value="${sessionScope.listOrder}"></c:set>
							<c:if test="${empty listOrder }">
								<h2>Bạn chưa có đặt đơn nào</h2>
							</c:if>
							<c:if test="${not empty listOrder}">
								<ol>
									<c:forEach var="order" items="${ list}">
										<li>Đơn hàng ngày ${order.date} tổng tiền là
												${order.totalPrice}$</li>
										<table id="cart">
											<tr>
												<th>Điện thoại</th>
												<th>Số lượng</th>
												<th>Thành tiền</th>
											</tr>
											<c:forEach var="item" items="${order.listItems}">
												<tr>
													<td style="text-align: left">${item.name}</td>
													<td>${item.number}</td>
													<td>${item.amount}</td>
												</tr>

											</c:forEach>
										</table>

											<hr/>
									</c:forEach>

								</ol>
							</c:if>
						</div>

					</div>


					<div class="dash--right">

						<c:import url="/Card.jsp"></c:import>
					</div>
				</section>
			</div>
					<footer>
			<div>
				<a href="#">Về chúng tôi</a>
			</div>
			<p>&copy; 2021 DevPhone -- Hệ thống bán lẻ điện thoại toàn quốc</p>
		</footer>
			

		</div>



</body>

</html>