<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%> 
<%@ page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<c:forEach items="${spittleList}" var="spittle">
	<li id="spittle_<c:out value="${spittle.id }"/>" >
		<div class="spittleName">
			<c:out value="${spittle.name}"/>
		</div>
		<div>
			<a href='<c:url value="/spittles/${spittle.id}"/>'><c:out value="${spittle.id}"/> </a>
		</div>		
	</li>
</c:forEach>



<span><a href="<c:url value='/spittles'/>" >我是 spittles</a></span>
</body>
</html>
