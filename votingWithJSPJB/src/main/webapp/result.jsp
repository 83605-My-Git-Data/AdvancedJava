<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>


		<h3>${ initParam.appTitle }</h3>
		
		Hello, ${lb.user.firstName}  ${lb.user.lastName }
		
		<jsp:useBean id="rb" class="com.sunbeam.beans.CandidateListBean" />
		
		${rb.fetchCandidates() } 
		
		<table border="1">
		<thead>
			<th>Id</th>
			<th>Name</th>
			<th>Party</th>
			<th>Votes</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach var="c" items="${rb.candidateList}">
				<tr>
					<td>${c.id}</td>
					<td>${c.name}</td>
					<td>${c.party}</td>
					<td>${c.votes}</td>
					<td>
						<a href="editcand.jsp?id=${c.id}">
							<img src="Images/update.jpeg" alt="Edit" width="24" height="24"/>
						</a>
						<a href="delcand.jsp?id=${c.id}">
							<img src="Images/delete.jpeg" alt="Del" width="24" height="24"/>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br/><br/>
	<a href="logout.jsp">Sign Out</a>
</body>
</html>