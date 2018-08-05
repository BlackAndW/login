<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<script type="text/javascript" src="Resources/js/common.js"></script>

<link rel="stylesheet" href="Resources/css/form-elements.css">
<link rel="stylesheet" href="Resources/css/style.css">

<title>注册</title>
</head>

<body>
   
	<h1>注册页面</h1>
	<p class="info">请输入注册信息</p>
	<p class="warning">${msg }</p>
<div class="form">
	<form id="form" action="RegisterController" method="post">
	<div class="form-group">
		<table id="register">
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" placeholder="请输入用户名"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" placeholder="请输入密码"></td>
			</tr>
			<tr>
				<td><input type="button" value="注册" class="btn" onclick="check()"></td>
				<td><input type="button" value="取消" class="btn" onclick=history.go(-1)></td>
			</tr>
		</table>
		</div>
	</form>
</div>

</body>
</html>
