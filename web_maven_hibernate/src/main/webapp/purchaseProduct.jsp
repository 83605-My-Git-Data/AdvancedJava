<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="purchase.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter Product id</td>
				<td><input type="text" name="id" /></td>
			</tr>
			
			<tr>
				<td>Enter Product Quantity</td>
				<td><input type="number" name="quantity" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Purchase Product" /></td>
				</tr>
		</table>
	</form>

</body>
</html>