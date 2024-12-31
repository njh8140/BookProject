<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,vo.Book"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>도서 정보 목록</h1>
	<a href="add.do">신규등록</a>
		<form action="search.do" method="get">
			책제목: <input type="text" name="keyword">
			<input type="submit" value="검색">
		</form>
	<hr>
	<c:forEach var="s" items="${requestScope.books}">
		${s.id}, 
		<a href="update.do?no=${s.id}">${s.title}</a>, 
		${s.author}, 
		${s.category}, 
		${s.publisher}, 
		${s.price} <br>
	</c:forEach>
</body>
</html>