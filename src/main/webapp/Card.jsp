<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<div class="cart">
	<h1 id="mark">Giỏ hàng của bạn</h1>
	<c:set var="cart" value="${sessionScope.Cart.listItems}"></c:set>
	<c:if test="${empty cart }">
		<p class="noItem">Chưa có món hàng nào</p>

	</c:if>

	<table id="cart">

		<c:if test="${!empty cart }">
			<tr>
				<th>Điện thoại</th>
				<th>Số lượng</th>
			</tr>


			<c:forEach var="item" items="${cart}">
				<tr>
					<td>${item.name}</td>
					<td>${item.number}</td>
					<td id="delete" data-id="${item.id}">Xóa</td>
				</tr>
			</c:forEach>

		</c:if>

	</table>
	<c:if test="${!empty cart }">
		<a href="MVC?action=checkout"><button id="btn--cart">Thanh
				toán</button></a>
	</c:if>
</div>

<script src="${pageContext.request.contextPath}/Asset/js/addToCart.js"></script>
</html>
