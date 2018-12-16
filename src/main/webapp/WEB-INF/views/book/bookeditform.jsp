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
	<form action="/books/edit" method=POST>
		BookName:<br> <input type="text" value="${book.bookName}" name="bookName"><br>
		DatePublished:<br> <input type="date" value="${book.datePublished}" name="datePublishedString"><br>
		ISBN:<br> <input type="number" value="${book.ISBN}" name="ISBN"><br>
		BookAuthorId:<br> <input type="number" value="${book.bookAuthorId}" name="bookAuthorId"><br>
		LibraryId:<br> <input type="text" value="${book.libraryId}" name="libraryId"><br>
		<input type="hidden" value="${book.id}" name="bookId">
		<input type="submit" value="Zapisz zmiany!">
	</form>

</body>
</html>