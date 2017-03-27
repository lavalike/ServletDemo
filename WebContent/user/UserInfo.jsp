<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>用户信息</h1>
	<jsp:useBean id="userinfo" scope="session" class="entity.User" />
	<table>
		<tr>
			<td>姓名</td>
			<td><jsp:getProperty name="userinfo" property="name" /></td>
		</tr>
		<tr>
			<td>性别</td>
			<td><jsp:getProperty name="userinfo" property="sex" /></td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><jsp:getProperty name="userinfo" property="age" /></td>
		</tr>
	</table>
</body>
</html>