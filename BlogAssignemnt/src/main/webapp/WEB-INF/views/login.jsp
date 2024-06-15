<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   

    <jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session" />
    <jsp:setProperty name="lb" property="email" param="email" />
    <jsp:setProperty name="lb" property="password" param="password" />

    <c:out value="${lb.authenticate()}" />
    
    <c:choose>
    
    <c:when test="${lb.getUser() !=null }">
    
    		<c:redirect url="ctl?page=bloglist"/>
    
    
    </c:when>
    
    <c:otherwise>
    
     <h1>${initParam.AppTitle}</h1>
     Invalid email or password,try again
     
     <a href="ctl?page=index">Login</a>
    
    
    
    
    </c:otherwise>
    
    </c:choose>

</body>
</html>
