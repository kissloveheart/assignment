
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


	<div class="loginPage">
<!--  check login or not -->
<c:if test="${ !empty sessionScope.login}">
<c:redirect url="Home.jsp"></c:redirect>
</c:if>
		<form action="Login" method="post" onsubmit="return validateForm()" class="login">
			<div class="loginLogo">
				<a href="${pageContext.request.contextPath}/MVC?action=home"><img src="Asset/image/logo.png" alt="logo"></a>
				<h1><a href="MVC?action=register"><i class="fa fa-user-plus" aria-hidden="true"></i>&nbsp; Đăng ký</a> nếu chưa có tài khoản</h1>
			</div>

			
			<div class="login__fail hidden">
				<i class="fa fa-exclamation-circle" aria-hidden="true"></i>
				<span>&nbsp;Sai tài khoản hoặc mật khẩu</span>
			</div>

			<div class="login--input">
				<div class="imgLogin">
					<i class="fa fa-user-circle-o" aria-hidden="true"></i>
				</div>
				<label for="uname">
				<i class="fa fa-envelope-o" aria-hidden="true"></i>&nbsp;<b>Email
						đăng nhập</b></label>
						 <input type="text" placeholder="Enter Username"
					name="uname" id="uname__login" value="${cookie.user.value }">
				<p class="login__error hidden" id="user">Vui lòng nhập tên đăng
					nhập</p>
				<p class="login__error hidden" id="user1">Email không đúng định dạng</p>
				<label for="psw"><i class="fa fa-key fa-fw"></i><b>&nbsp;Mật
						khẩu</b></label>
				 <input type="password" placeholder="Enter Password"
					name="psw" id="psw__login" value="${cookie.user.value }">
				<p class="login__error hidden" id="password">Vui lòng nhập mật
					khẩu</p>
					<p class="login__error hidden" id="password1">Mật khẩu không đúng định dạng</p>
				<label> <input type="checkbox" checked="checked"
					name="remember"> Ghi nhớ
				</label>

				<button type="submit" id="submit__login">Đăng nhập</button>
				<div class="forget">
					<a href="#">Quên mật khẩu?</a>
				</div>

			</div>


		</form>
	</div>
	<script src="Asset/js/login.js"></script>
		
<!--  show login success or fail -->
	
	<c:if test="${requestScope.loginSuccess eq 'nok' }">
	<script type="text/javascript">
    document.querySelector(".login__fail").classList.remove("hidden");	   
    </script>
	
	</c:if>
	
</body>
</html>