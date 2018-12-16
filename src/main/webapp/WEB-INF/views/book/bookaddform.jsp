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


	<form action="/books/add" method=POST>
		BookName:<br> <input type="text" name="bookName"><br>
		DatePublished:<br> <input type="date" name="datePublishedString"><br>
		ISBN:<br> <input type="number" name="ISBN"><br>
		<c:choose>
			<c:when test="${not empty bookAuthorId}">
				<p>
					BookAuthorId:
					<c:out value=" ${bookAuthorId}"></c:out>
					<input type="hidden" value="${bookAuthorId}" name="bookAuthorId">
				</p>
			</c:when>
			<c:otherwise>BookAuthorId:<br>
				<input type="number" name="bookAuthorId">
				<br>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${not empty libraryId}">
				<p>
					LibraryId:
					<c:out value=" ${libraryId}"></c:out>
					<input type="hidden" value="${libraryId}" name="libraryId">
				</p>
			</c:when>
			<c:otherwise>LibraryId:<br>
				<input type="text" name="libraryId">
				<br>
			</c:otherwise>
		</c:choose>
		<input type="submit" value="Dodaj!">
	</form>

</body>
</html>