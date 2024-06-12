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


	<h3>${initParam.appTitle}</h3>
	
	<jsp:useBean id="vote" class="com.sunbeam.beans.VoteBean" scope="session" />
	<jsp:setProperty name="vote" property="candidateId" param="candidate"  />
	<jsp:setProperty name="vote" property="voterID" value="${lb.user.id}" />
	
	
	
	
	 
	
	
	 <c:choose>
	<c:when test="${lb.user.status == 0 }">
	
	
				${ vote.voteCandidate() }
				voted successfully
	
	
	
	
	
	</c:when>
	<c:when test="${lb.user.status ==1 }">
	
	
				You have already voted
	
	
	
	
	
	</c:when>
	
	 </c:choose>
	
	
		
	
	
	
	

</body>
</html>