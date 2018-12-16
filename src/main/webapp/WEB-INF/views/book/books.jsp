<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>

<title>LibraryApp</title>
</head>
<body>
<%@include file="../fragment/header.jspf"%>
	<h1>Books</h1>
	<table style="border: 1px solid black">
		<tr>
			<th>BookId</th>
			<th>BookName</th>
			<th>DatePublished</th>
			<th>ISBN</th>
			<th>BookAuthorName and Surname</th>

		</tr>
		<c:forEach var="book" items="${bookList}">
			<tr>
				<th><a href="${pageContext.request.contextPath}/books/${book.id}">${book.id}</a></th>
				<th>${book.bookName}</th>
				<th>${book.datePublished}</th>
				<th>${book.ISBN}</th>
				<th><a href="${pageContext.request.contextPath}/authors/${book.bookAuthorId}"><c:out
							value="${book.bookAuthorFirstName} ${book.bookAuthorLastName}">Imię i nazwisko</c:out></a></th>
				<th><a href="${pageContext.request.contextPath}/books/edit/${book.id}">Edytuj</a>
				<th><a href="${pageContext.request.contextPath}/books/delete/${book.id}">Usuń</a>
			</tr>
		</c:forEach>
	</table>
	<h2>
		<a href="${pageContext.request.contextPath}/books/add">Dodaj książkę</a>
	</h2>

</body>
</html>