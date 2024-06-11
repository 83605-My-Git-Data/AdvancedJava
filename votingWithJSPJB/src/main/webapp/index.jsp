<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<h3>${initParam.appTitle}</h3>


<form method="post" action="login.jsp">

Email: <input type="text" name="email"/>
<br/><br/>
Password: <input type="password" name="password">
<br/><br/>
<input type="submit" value="Sign IN">
<a href="newuser.jsp">Sign UP</a>
</form>
</body>
</html>