<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${initParam.AppTitle }</h1>

	<form method="post" action="ctl?page=login">
	
	Email: <input type="text" name="email"/><br/></br>
	Password: <input type="password" name="password"><br/></br>
	<input type="submit" Value="Log IN" >
	<br/></br>
	<a href="ctl?page=newuser" >Sign UP</a>
	</form>


</body>
</html>