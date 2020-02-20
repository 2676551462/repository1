<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="book/addBook" method="post">
	<input type="hidden" name="isbn"><br>
	书名<input type="text" name="book_name"><br>
	价格<input type="text" name="price"><br>
	<input type="submit" value="提交">
	</form>
</body>
</html>