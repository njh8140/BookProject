<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>도서 정보 수정</h1>
	<hr>
	<form action="update.do" method="post">
		<table>
		<tr><th>번호</th><td><input type="number" name="id" value="${requestScope.book.getId()}" readonly></td></tr>
		<tr><th>책제목</th><td><input type="text" name="title" value="${requestScope.book.getTitle()}"></td></tr>
		<tr><th>저자</th><td><input type="text" name="author" value="${requestScope.book.getAuthor()}"></td></tr>
		<%-- <tr><th>카테고리</th><td><input type="text" name="category" value="${requestScope.book.getCategory()}" readonly></td></tr> --%>
		
		<tr><th><label for="category">카테고리</label></th>
		<td>
			<select id="category" name="category">
			
				<option value="문화" selected>문화</option>
				<option value="예술">예술</option>
				<option value="과학">과학</option>
				<option value="인문">인문</option>
			</select>
		</td>
		</tr>
		
		<tr><th>출판사</th><td><input type="text" name="publisher" value="${requestScope.book.getPublisher()}"></td></tr>
		<tr><th>발행일</th><td><input type="date" name="pub_date" value="${requestScope.book.getPub_date()}"></td></tr>
		<tr><th>ISBN</th><td><input type="text" name="isbn" value="${requestScope.book.getIsbn()}"></td></tr>
		<tr><th>가격</th><td><input type="number" name="price" value="${requestScope.book.getPrice()}"></td></tr>
		<tr><th>등록일</th><td><input type="date" name="cre_date" value="${requestScope.book.getCre_date()}"></td></tr>
		<tr><th>수정일</th><td><input type="date" name="mod_date" value="${requestScope.book.getMod_date()}"></td></tr>
		
		<tr><th colspan="2">
			<input type="submit" value="수정">
			<input type="reset" value="취소">
			<input type="button" value="삭제" onclick='location.href="delete.do?id=${requestScope.book.getId()}"'>
			</th></tr>
		</table>
	</form>
</body>
</html>