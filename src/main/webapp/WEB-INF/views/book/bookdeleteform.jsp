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
	<form action="/books/delete" method=POST>
		BookName:<p><c:out value="${book.bookName}">BookName</c:out></p><br>
		DatePublished:<p><c:out value="${book.datePublished}">DatePublished</c:out></p><br>
		ISBN:<p><c:out value="${book.ISBN}">ISBN</c:out></p><br>
		BookAuthorId:<p><c:out value="${book.bookAuthorId}">bookAuthorId</c:out></p><br>
		LibraryId:<p><c:out value="${book.libraryId}">libraryId</c:out></p><br>
		<input type="hidden" value="${book.id}" name="bookId">
		<input type="submit" value="Usuń!">
	</form>

</body>
</html>