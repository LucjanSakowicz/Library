<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Spring CMS</title>
</head>
<body>
	<h1><c:out value="${helloMessage}" /></h1>
	
	<ul>
	<c:forEach var="user" items="${userList}">
	<li><c:out value="${user.username}"/><br>
	<c:out value="${user.firstName}"/><br>
	<c:out value="${user.lastName}"/><br>
	<c:out value="${user.isBanned}"/><br>
	<c:out value="${user.userRole}"/><br>
	</li>
	
	</c:forEach>
	</ul>
</body>
</html>