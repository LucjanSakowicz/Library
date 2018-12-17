<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BookEdit</title>
</head>
<body>
	<%@include file="../fragment/header.jspf"%>
	<form action="/users/delete" method=POST>
		UserName:<p><c:out value="${user.userName}">UserName</c:out></p><br>
		Email:<p><c:out value="${user.email}">Email</c:out></p><br>
		FirstName:<p><c:out value="${user.firstName}">FirstName</c:out></p><br>
		LastName:<p><c:out value="${user.lastName}">LastName</c:out></p><br>
		UserRole:<p><c:out value="${user.userRoleName}">UserRoleName</c:out></p><br>
		IsBanned:<p><c:out value="${user.isBanned}">IsBanned</c:out></p>
		<input type="hidden" value="${user.id}" name="userId">
				<!--  dodanie tokena csrf, nie jest potrzebne dla thymeleafa lub Spring MVC taglib  -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="Usuń!">
	</form>

</body>
</html>