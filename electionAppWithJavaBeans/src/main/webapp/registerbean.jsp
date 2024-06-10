<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Bean- Register</title>
</head>
<body>

		<jsp:useBean id="lb" class="appWithbean.RegisterBean" />
		
		<jsp:setProperty name="lb" property="firstName" param="firstName"/>
		<jsp:setProperty name="lb" property="lastName" param="lastName"/>
		<jsp:setProperty name="lb" property="email" param="email"/>
		<jsp:setProperty name="lb" property="password" param="password"/>
		<jsp:setProperty name="lb" property="dob" param="dob"/>
		<jsp:setProperty name="lb" property="role" param="voter"/>
		
		
		
		
		<% lb.registerMe(); %>
		<%if(lb.getCount() !=0) {%>
		User Registered
		<%} %>
		
		
		
		
		

</body>
</html>