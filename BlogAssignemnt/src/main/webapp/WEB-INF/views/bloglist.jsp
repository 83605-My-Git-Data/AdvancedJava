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

		<h1>${initParam.AppTitle }</h1>
		<br/>
		<br/>
		
		<jsp:useBean id="blb" class="com.sunbeam.beans.BlogListBean"/>
		
		
		${blb.getBlogs() }
		
		<a href="ctl?page=myblogs">My Blogs </a>
		
		<br/>
		<br/>
		
		
		<table>
		
			<thead>
			
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>Contents</th>
					<th>Created On</th>
					<th>UserId</th>
					<th>CategoryId</th>
					<th>Actions</th>
				
				
				</tr>
			
			
			
			</thead>
			
			
			<tbody>
			
			<c:forEach var="b" items="${blb.getBlogList() }" >
					<tr>
					
					
						<td>${b.id}</td>
						<td> ${b.title} </td>
						<td>   ${b.contents} </td>
						<td>   ${b.createdOn} </td>
						<td>  ${b.userId} </td>
						<td>  ${b.categoryId} </td>
						
					
					
					</tr>
					
					</c:forEach>
			
			
				
			
			
			</tbody>
		
		
		</table>
		
		<a href="ctl?page=addblogs">Add Blogs</a>
		

</body>
</html>