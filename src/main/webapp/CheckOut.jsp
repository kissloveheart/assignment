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
			<div class="title">CHI TIẾT HÓA ĐƠN</div>


			<div class="order">
				<c:set var="cart" value="${sessionScope.Cart.listItems}"></c:set>
				<c:set var="total" value="${sessionScope.Cart.amount}"></c:set>
				<c:if test="${empty cart }">
					<h1>Chưa có món hàng nào</h1>
				</c:if>

				<c:if test="${!empty cart }">
				<div class="order__table">
					<table id="cart">
							<tr>
								<th>Điện thoại</th>
								<th>Số lượng</th>
								<th>Thành tiền</th>
							</tr>
	
	
							<c:forEach var="item" items="${cart}">
								<tr>
									<td style="text-align: left">${item.name}</td>
									<td><a href="ModifyCheckOut?action=des&id=${item.id}"><button
												class="btn--number">-</button></a>&nbsp;&nbsp;${item.number}&nbsp;&nbsp;<a
										href="ModifyCheckOut?action=ins&id=${item.id}"><button
												class="btn--number">+</button></a></td>
									<td>${item.amount}</td>
									<td><a
										href="ModifyCheckOut?action=remove&id=${item.id}" class="delete--a">Xóa</a></td>
								</tr>
							</c:forEach>
						<tr>
							<td colspan="2" style="text-align: left"><strong>Tổng
									tiền</strong></td>
							<td style="color: #f03e3e"><strong>${total}$</strong></td>
						</tr>

					</table>
</div>
					<div class="order__info">
						<h2>Thông tin nhận hàng</h2>
						<c:set var="acc" value ="${sessionScope.login}"></c:set>
						<form action="OrderSubmit" method="get" onsubmit="">

							<div class="login--input">
								<label for="name"> Tên người nhận</label> <input type="text"
									name="name" data-id="1" required value="${acc.username}">
								<p class="login__error hidden" id="1">Vui lòng nhập tên
									người nhận</p>
									
								<label for="phone">Số điện thoại</label> 
								<input type="tel" title="Must have 10 digit" pattern="[0-9]{10}" name="phone" data-id="2" value="${acc.phone}" required>
								<p class="login__error hidden" id="2">Vui lòng nhập đúng số
									điện thoại</p>


								<label for="adr">Địa chỉ</label> 
								<input type="text" name="adr" data-id="3" required value="${acc.address}">
								<p class="login__error hidden" id="3">Vui lòng nhập địa chỉ</p>						
								<br>							
								<button type="submit" class="btn--order">Đặt hàng</button>
							</div>


						</form>
					</div>
				</c:if>
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


		</div>
	</section>

	<c:import url="Footer.jsp"></c:import>
</body>
</html>