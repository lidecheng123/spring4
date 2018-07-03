<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>我是单个Spittle</h1>
	<form action="<c:url value="/spittles/save"/>" method="POST">
		<span><c:out value="${spittle.id}" /></span> <input type="hidden"
			name="id" value="<c:out value="${spittle.id }"/>" /> <br />
		<input type="text" name="name"
			value="<c:out value="${spittle.name }"/>" />
		<input type="submit" value="修改" />
	</form>
</body>
</html>
