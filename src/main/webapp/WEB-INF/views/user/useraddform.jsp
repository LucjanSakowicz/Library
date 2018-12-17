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


	<form action="/users/add" method=POST>
		Username:<br> <input type="text" name="userName"><br>
		Password:<br> <input type="password" name="password"><br>
		Email:<br> <input type="email" name="email"><br>
		FirstName:<br> <input type="text" name="firstName"><br>
		LastName:<br> <input type="text" name="lastName"><br>
		<input type="submit" value="Dodaj!">
	</form>

</body>
</html>