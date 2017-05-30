<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<meta charset="utf-8">
<title>hzp-Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel='stylesheet'
	href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
<link rel="stylesheet" href="public/assets/css/reset.css">
<link rel="stylesheet" href="public/assets/css/supersized.css">
<link rel="stylesheet" href="public/assets/css/style.css">

</head>

<body>
	<div class="page-container">
		<h1>Login</h1>
		<form action="<%=basePath%>/main" method="get">
			<input type="text" name="username" class="username"
				placeholder="Username"> <input type="password"
				name="password" class="password" placeholder="Password">
			<button type="submit">Sign me in</button>
			<div class="error">
				<span>+</span>
			</div>
		</form>
		<div class="connect">
			<p>Or connect with:</p>
			<p>
				<a class="facebook" href=""></a> <a class="twitter" href=""></a>
			</p>
		</div>
	</div>
	<div align="center">
		Collect from <a href="http://www.cssmoban.com/" target="_blank"
			title="楚门">楚门</a>
	</div>

	<script src="public/assets/js/jquery-1.8.2.min.js"></script>
	<script src="public/assets/js/supersized.3.2.7.min.js"></script>
	<script src="public/assets/js/supersized-init.js"></script>
	<script src="public/assets/js/scripts.js"></script>

</body>

</html>