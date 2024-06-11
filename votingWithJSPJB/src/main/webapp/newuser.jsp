<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>${initParam.appTitle}</h3>
	
	
	<form method="post" action="register.jsp">
	
	
	First Name : <input type="text" name="firstName"/> <br/><br/>
	Last Name : <input type="text" name="lastName"/> <br/><br/>
	Email  : <input type="text" name="email"/> <br/><br/>
	Password : <input type="password" name="password"/> <br/><br/>
	Birth Date : <input type="date" name="birth"/> <br/><br/>
	<input type="submit" value="Register"/>
	
	</form>
	

</body>
</html>