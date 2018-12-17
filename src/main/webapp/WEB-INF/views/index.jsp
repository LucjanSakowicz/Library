<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Strona główna</title>
</head>
<body>
	<%@include file="fragment/header.jspf"%>
	<form action="${pageContext.request.contextPath}/logout" method="post">
		<input type="submit" value="Logout" />
	</form>
	<a href="${pageContext.request.contextPath}/users">Users</a>
	<a href="${pageContext.request.contextPath}/books">Books</a>
</body>
</html>