<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>${ initParam.AppTitle }</h1>
	
	
	<form method="post" action="ctl?page=register">
	
	Name: <input type="text" name="name"> <br/><br/>
	Email: <input type="text" name="email"> <br/><br/>
	Password: <input type="password" name="password"> <br/><br/>
	Phone No: <input type="text" name="phone"> <br/><br/>
	
	<input type="submit" Value="register">
	
	</form>
	

</body>
</html>