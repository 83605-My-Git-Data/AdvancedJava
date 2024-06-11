<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
 <%@ page import="com.sunbeam.pojos.Candidate" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3> ${initParam.appTitle} </h3>
Hello, ${lb.user.firstName} ${lb.user.lastName}
<hr/>
 
<jsp:useBean id="clist" class="com.sunbeam.beans.CandidateListBean" scope="session"/>
${ clist.fetchCandidates() }


<form method="post" action="vote.jsp" >

<c:forEach var="c" items="${ clist.candidateList }">

<input type="radio" name="candidate" value="${c.id }"/> ${c.name} - ${c.party }<br/>



</c:forEach>

<br/> <input type="submit" value="vote" />

</form>


</body>
</html>