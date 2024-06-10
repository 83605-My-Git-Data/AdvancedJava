
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>Here is JSP Syntax demo </h1>

<!--this is html comment-->

<%--this is JSP comment --%>

<%-- JSP declaration --%>

<%!

 int count = 0;

public void jspInit(){
	System.out.println("demo1 jspInit() called");
}


public void jspDestroy(){
	System.out.println("demo1 jspDestroy() called ");
}

%>


<%-- JSP scriplet --%>

<%

Date date = new Date();
out.println("Server Time: "+date);

%>




<% count++; %>

<% out.println(count); %>


	<% count++; %>
	<% if(count % 2 == 0) { %>
		Even Count: <%= count %>
	<% } else { %>	
		Odd Count: <%= count %> <%-- JSP Expression --%>
	<% } %>






</body>
</html>