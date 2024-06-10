<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Beans</title>
</head>
<body>

	<jsp:useBean id="lb" class="appjsp.LoginBean" />
	<jsp:setProperty name="lb" property="email" param="email"/>
	<jsp:setProperty name="lb" property="password" param="passwd" />
	<% lb.authenticate(); %>
	<% if(lb.getUser() != null) { %>
	 Welcome, <jsp:getProperty name="lb" property="email" />
	 <%} else { %>
	 Login Failed.
	 
	 <% } %>
	
	
	


</body>
</html>


