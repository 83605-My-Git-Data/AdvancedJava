<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Candidate</title>
</head>
<body>

	<h3>${ initParam.appTitle }</h3>
	<jsp:useBean id="fcb" class="com.sunbeam.beans.FindCandidateBean" />
	<jsp:setProperty name="fcb" property="id" param="id"/>
	
	${ fcb.fetchCandidate() }
	
	<form method="post" action="updatecandidate.jsp">
		<input type="hidden" name="id" value="${fcb.candidate.id}"/>
		Name: <input type="text" name="name" value="${fcb.candidate.name}"/> <br/><br/>
		Party: <input type="text" name="party" value="${fcb.candidate.party}"/> <br/><br/>
		Votes: <input type="text" name="votes" value="${fcb.candidate.votes}" readonly="readonly"/> <br/><br/>
		<input type="submit" value="Update Candidate"/>
	</form>
	

</body>
</html>