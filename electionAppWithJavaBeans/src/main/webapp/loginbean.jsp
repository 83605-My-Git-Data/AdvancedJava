<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Bean-Login</title>
</head>
<body>

<jsp:useBean id="bin" class="appWithbean.LoginBean"/>
<jsp:setProperty name="bin" property="email" param="email"/>
<jsp:setProperty name="bin" property="password" param="password"/>


</body>
</html>