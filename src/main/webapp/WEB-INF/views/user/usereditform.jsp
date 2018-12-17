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
	<form action="/users/edit" method=POST>
		Username:<br> <input type="text" value="${user.userName}"
			name="userName"><br> Password:<br> <input
			type="password" value="" name="password"><br> Email:<br>
		<input type="email" value="${user.email}" name="email"><br>
		FirstName:<br> <input type="text" value="${user.firstName}"
			name="firstName"><br> LastName:<br> <input
			type="text" value="${user.lastName}" name="lastName"><br>
		<c:choose>
			<c:when test="${user.isBanned}">
				<p>
					IsBanned:<br> Zbanowany<input type="radio" value="true" name="isBanned"
						checked="checked"> <br> Aktywny <input type="radio" value="false"
						name="isBanned"> <br>
				</p>
			</c:when>
			<c:otherwise>
				<p>
					IsBanned:<br> Zbanowany<input type="radio" value="true" name="isBanned">
					<br> Aktywny<input type="radio"
						checked="checked" value="false" name="isBanned"> <br>
				<p>
			</c:otherwise>
		</c:choose>
		UserRoleName: <br> <input type="text" value="${user.userRoleName}"
			name="userRoleName"><br> <input type="hidden"
			value="${user.id}" name="userId"> <input type="submit"
			value="Zapisz zmiany!">
	</form>

</body>
</html>