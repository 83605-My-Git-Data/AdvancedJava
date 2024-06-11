<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Candidate</title>
</head>
<body>


	<h3>${initParam.appTitle}</h3>
	<jsp:useBean id="ucb" class="com.sunbeam.beans.UpdateCandidateBean"/>
	<jsp:setProperty name="ucb" property="*" />
	${ ucb.updateCandidate() }
	<c:choose>
		<c:when test="${ucb.count == 1}">
			<c:redirect url="result.jsp"/>
		</c:when>
		<c:otherwise>
			Candidate update failed. <br/><br/>
			<a href="result.jsp">Show Result</a>
		</c:otherwise>
	</c:choose>

</body>
</html>