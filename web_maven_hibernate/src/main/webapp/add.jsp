<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add product page</title>
</head>
<body>

<!-- //transferring form req param to javabean props -->

<jsp:setProperty property="*" name="product_bean" />

<h5>${sessionScope.product_bean.addNewProduct() } </h5>

</body>
</html>