<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<jsp:useBean id="rb" class="com.sunbeam.beans.RegisterBean" scope="session" />
	<jsp:setProperty name="rb" property="name" param="name" />
    <jsp:setProperty name="rb" property="password" param="password" />
	<jsp:setProperty name="rb" property="email" param="email" />
    <jsp:setProperty name="rb" property="phone" param="phone" />

	
	
	
  ${rb.register()} 
	
	<c:choose >
	
	 <c:when test="${rb.count == 1 }">
	 		Successfully registered user
	 		
	 		<a href="ctl?page=index">Login</a>
	 
	 
	 
	 </c:when>
	 
	 
	 <c:otherwise>
	 
	 	Registration failed
	 	<a href="ctl?page=newuser">Sign UP</a>
	 
	 </c:otherwise>
	
	
	
	
	</c:choose>
	
	
	

</body>
</html>