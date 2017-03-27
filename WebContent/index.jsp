<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlet Program</title>
</head>
<body>
	<h1>文件上传</h1>
	<a href="upload">请求</a>
	
	<h1>请求json</h1>
	<a href="JsonServlet">请求</a>

	<h1>生命周期</h1>
	<a href="lifecycle">Servlet生命周期</a>

	<h1>Servlet获取表单数据</h1>
	<form action="register" method="post" name="regForm">
		<table>
			<tr>
				<td>姓名</td>
				<td><input type="input" name="input_name" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="input" name="input_sex" /></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="input" name="input_age" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="提交" /> <input type="reset"
					value="重置" /></td>
			</tr>
		</table>
	</form>

	<h1>路径跳转</h1>
	<a href="hello">相对路径</a>
	<br />
	<a href="<%=path%>/hello">绝对路径</a>
	<br />
	<a href="RedirectServlet">访问RedirectServlet，跳转到Redirect.jsp</a>

	<h1>用户登录</h1>
	<a href="login/Login.jsp">登录</a>

	<h1>获取初始参数</h1>
	<a href="InitParamServlet">进入</a>

</body>
</html>