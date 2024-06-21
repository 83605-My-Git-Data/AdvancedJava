<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		Welcome !
	</h2>
	
	
	<c:url var="url" value="/products/between?startPrice=100&endPrice=2000"></c:url>
	<a href="${url }">Get Products</a>
	
</body>
</html>