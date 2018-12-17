<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BookAdd</title>
</head>
<body>
	<%@include file="../fragment/header.jspf"%>


	<form action="${pageContext.request.contextPath}/loginform" method="post">
		Username:<br> <input type="text" name="username"><br>
		Password:<br> <input type="password" name="password"><br>
		<!--  dodanie tokena csrf, nie jest potrzebne dla thymeleafa lub Spring MVC taglib  -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="Zaloguj">
	</form>
	<form action="${pageContext.request.contextPath}/register" method=GET>
	<input type="submit" value="Zarejestruj">
	</form>

</body>
</html>