<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>

<title>LibraryApp</title>
</head>
<body>
	<h1>Users</h1>
	<table style="border:1px solid black">
		<tr>
			<th>UserId</th>
			<th>Username</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>IsBanend</th>
			<th>UserRole</th>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
			<th><a href="/users/userdetails/${user.id}">${user.id}</a></th>
			<th>${user.username}</th>
			<th>${user.firstName}</th>
			<th>${user.lastName}</th>
			<th>${user.isBanned}</th>
			<th>${user.userRole}</th>
			</tr>
		</c:forEach>
	</table>
	<a href="/">Powrót</a>

</body>
</html>