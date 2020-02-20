<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/book/updateBook" method="post">
		<input type="hidden" name="isbn" value="${book.isbn}"><br>
		书名<input type="text" name="book_name" value="${book.bookName}"><br>
		价格<input type="text" name="price" value="${book.price}"><br>
		<input type="submit" value="提交">
	</form>

</body>
</html>