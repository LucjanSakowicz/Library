<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>

<title>LibraryApp</title>
</head>
<body>
<%@include file="../fragment/header.jspf" %>
<h1> AuthorDetails</h1>

<h1>${author.firstName}</h1>
<h2>${author.id}</h2>
<table style="border: 1px solid black">
		<tr>
			<th>BookId</th>
			<th>BookName</th>
			<th>DatePublished</th>
			<th>ISBN</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="book" items="${books}">
			<tr>
				<th><a href="/books/${book.id}">${book.id}</a></th>
				<th>${book.bookName}</th>
				<th>${book.datePublished}</th>
				<th>${book.ISBN}</th>
				<th><a href="/books/edit/${book.id}">Edytuj</a>
				<th><a href="/books/delete/${book.id}">Usuń</a>
			</tr>
		</c:forEach>
	</table>
	<h2>
		<a href="/books/add?bookAuthorId=${author.id}">Dodaj książkę</a>
	</h2>

	

</body>
</html>