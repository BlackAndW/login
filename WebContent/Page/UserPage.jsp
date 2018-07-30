<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018/7/13
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>HomePage</title>
</head>
<body>
	当前在线人数：<%=session.getAttribute("OnLineNum")%><br />
	${UserInfo['username'] },您好，您的身份是普通用户

</body>
</html>
