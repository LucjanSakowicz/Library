<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>

<title>LibraryApp</title>
</head>
<body>
<%@include file="../fragment/header.jspf" %>
	<h1>Users</h1>
	<table style="border:1px solid black">
		<tr>
			<th>UserId</th>
			<th>Username</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>IsBanend</th>
			<th>UserRole</th>
			<th></th>
			<th></th>
			
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
			<th><a href="${pageContext.request.contextPath}/users/${user.id}">${user.id}</a></th>
			<th>${user.username}</th>
			<th>${user.firstName}</th>
			<th>${user.lastName}</th>
			<th>${user.isBanned}</th>
			<th>${user.userRole}</th>
			<th><a href="${pageContext.request.contextPath}/books/edit/${user.id}">Edytuj</a>
			<th><a href="${pageContext.request.contextPath}/books/delete/${user.id}">Usuń</a>
			</tr>
		</c:forEach>
	</table>
	<h2>
		<a href="${pageContext.request.contextPath}/users/add">Dodaj</a>
	</h2>

</body>
</html>