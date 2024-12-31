<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,vo.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>도서 등록</h1>
	<hr>
	<form action="add.do" method="post">
		<table>
			<tr><th>책제목</th><td><input type="text" name="title"></td></tr>
			<tr><th>저자</th><td><input type="text" name="author"></td></tr>
			
			<tr><th><label for="category">카테고리</label></th>
			<td>
			<select id="category" name="category">
				<option value="문화">문화</option>
				<option value="예술">예술</option>
				<option value="과학">과학</option>
				<option value="인문">인문</option>
			</select>
			</td>
			</tr>
			
			<tr><th>출판사</th><td><input type="text" name="publisher"></td></tr>
			<tr><th>발행일</th><td><input type="date" name="pub_date"></td></tr>
			<tr><th>ISBN</th><td><input type="text" name="isbn"></td></tr>
			
			<tr><th>가격</th><td><input type="number" name="price"></td></tr>
			
			<tr><th>등록일</th><td><input type="date" name="cre_date"></td></tr>
			<tr><th>수정일</th><td><input type="date" name="mod_date"></td></tr>
			
			<tr><th colspan="2">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</th></tr>
		</table>
	</form>
</body>
</html>