<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>장바구니 보기</title>
</head>
<body>
<h3>장바구니 보기</h3>
<c:forEach var="b"  items="${list}">
	<div>제목 : ${b.title}</div>
</c:forEach>
<div>장바구니 총액 : ${total}</div>
<p>
<a href="/shop/book">계속 쇼핑하기</a>
</body>
</html>