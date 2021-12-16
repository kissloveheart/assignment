
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Login Page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Asset/css/style.css"
	type="text/css" />
<!-- Load an icon library to show a hamburger menu (bars) on small screens -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Asset/css/font-awesome.min.css">
</head>
<body>


	<div class="loginPage">

		<form action="Login" method="post" onsubmit="return validateForm()"
			class="login">
			<div class="loginLogo">
				<a href="${pageContext.request.contextPath}/MVC?action=home"><img
					src="Asset/image/logo.png" alt="logo"></a>
			</div>

			<div class="login__success">
				<p>Đặt hàng thành công, đang chuyển hướng</p>
				<br> <i class="fa fa-spinner fa-pulse fa-3x fa-fw"></i>
			</div>


		</form>
	</div>


	<c:if test="${requestScope.orderSuccess eq 'ok' }">

		<script type="text/javascript">
	setTimeout(()=>{window.location.replace("MVC?action=home");},1000);
</script>

	</c:if>



</body>
</html>