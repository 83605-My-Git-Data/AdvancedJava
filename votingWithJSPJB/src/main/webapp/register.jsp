<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sunbeam.beans.RegisterBean" %>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>

	<h3>${initParam.appTitle}</h3>


	<jsp:useBean id="rb" class="com.sunbeam.beans.RegisterBean" scope="page"/>
	 <jsp:setProperty name="rb" property="*"/> 
	<jsp:setProperty name="rb" property="status" value="0"/>
	<jsp:setProperty name="rb" property="role" value="voter"/>
	
	${ rb.registerMe()}
	
	<c:choose>
	
	<c:when test="${rb.count==1 }" >
			Registration Successful.
			<a href="index.jsp">Sign IN</a>
	
	</c:when>
	
	<c:otherwise>
		Registration Failed 
		
		<a href="newuser.jsp">Sign UP</a>
		
		</c:otherwise>
	
	
	</c:choose>
	
	
	
	
	
</body>
</html>