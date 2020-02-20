<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function () {
		$("[id ^= del]").click(function () {
			var href = $(this).attr("href");
			var bookName = $(this).parent().parent().find("td:eq(1)").text();
			if (confirm("您确定要删除<<"+bookName+">>吗？")) {
				$("#form1").attr("action",href).submit();
			}
			return false;
		})
	})
</script>
<body>
	<form id="form1" action="" method="post">
		<input type="hidden" name="_method" value="delete">
	</form>

	<table border="1px" align="center" width="50%" cellspacing="0px" cellpadding="10px">
		<tr>
			<th>编号</th>
			<th>书名</th>
			<th>价格</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list }" var="book">
			<tr align="center">
				<td>${book.isbn }</td>
				<td>${book.bookName }</td>
				<td>${book.price }</td>
				<td><a id="del_${book.isbn }" href="${pageContext.request.contextPath }/book/delete/${book.isbn}">删除</a>|
				<a href="${pageContext.request.contextPath }/book/getBookById/${book.isbn}">修改</a></td>
			</tr>
		</c:forEach>
		<tr align="center">
			<td colspan="4"><a href="${pageContext.request.contextPath }/add">添加</a></td>
		</tr>
	</table>
</body>
</html>