<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/search.css"/>">
<title>首页</title>
</head>
<body>
	<div>
		<a href="listCategory.jsp">登录</a>
	</div>
	<form action="listByName" method="post">
		<div id="box">
			<input type="text" name="name" placeholder="请输入关键字"> <input
				id="search" type="submit" value="搜索">
		</div>
	</form>
</body>
</html>