
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Login Page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/style.css" type="text/css" />
<!-- Load an icon library to show a hamburger menu (bars) on small screens -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Asset/css/font-awesome.min.css">
</head>
<body>
<!--  check login or not -->
<c:if test="${ !empty sessionScope.login}">
<c:redirect url="Home.jsp"></c:redirect>
</c:if>

	<div class="loginPage">


		<form action="Register" method="post" onsubmit="return validateRegister()" class="login">
			<div class="loginLogo">
				<a href="${pageContext.request.contextPath}/MVC?action=home"><img src="Asset/image/logo.png" alt="logo"></a>
				<h1><a href="MVC?action=login">Đăng nhập</a> nếu chưa có tài khoản</h1>
			</div>


			<div class="login--input">
				<label for="uname">
				<i class="fa fa-envelope-o" aria-hidden="true"></i>&nbsp;<b>Email
						đăng nhập</b></label>
						 <input type="text" placeholder="Enter email"
					name="uname" id="uname__login" value="">
				<p class="login__error hidden" id="user">Vui lòng nhập email đăng
					nhập</p>
				<div class="check">
				
				
				</div>
				<p class="login__error hidden" id="user1">Email không đúng định dạng</p>
				
				<label for="name"><i class="fa fa-user" aria-hidden="true"></i>&nbsp;<b>Tên của bạn</b></label>
						 <input type="text" placeholder="Enter Username"
					name="name" id="name__login" value="">
				<p class="login__error hidden" id="user2">Vui lòng nhập tên của bạn</p>
				
				
				<label for="psw"><i class="fa fa-key fa-fw"></i><b>&nbsp;Mật
						khẩu</b></label>
				 <input type="password" placeholder="Enter Password"
					name="psw" id="psw__login" value="">
				<p class="login__error hidden" id="password">Vui lòng nhập mật
					khẩu</p>
					<p class="login__error hidden" id="password1">Mật khẩu không đúng định dạng</p>
					
				<label for="psw"><i class="fa fa-key fa-fw"></i><b>&nbsp; Nhập lại mật
						khẩu</b></label>
				 <input type="password" placeholder="Reenter Password"
					name="psw" id="rpsw__login" value="">
				<p class="login__error hidden" id="password2">Vui lòng lại nhập mật
					khẩu</p>
					
				<p class="login__error hidden" id="password3">Mật khẩu nhập lại không đúng</p>
					<br/>
				<button type="submit" id="submit__login">Đăng ký</button>
			</div>


		</form>
	</div>
	<script src="${pageContext.request.contextPath}/Asset/js/register.js"></script>
		


</body>
</html>