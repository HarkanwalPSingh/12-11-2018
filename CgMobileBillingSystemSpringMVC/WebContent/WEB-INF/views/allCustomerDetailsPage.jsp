<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Customer Details</title>
</head>
<body>
	<div align="left">
		<h5 align="center">
			<font color="brown" size="4"> Details of Customers
				<table border="1" align="center">
					<tr>
						<th>CustomerID</th>
						<th>Name</th>
						<th>Email ID</th>
					</tr>
					<c:forEach items="${customers}" var="customer">
						<tr>
							<td>${customer.customerID}</td>
							<td>${customer.firstName} ${customer.lastName} </td>
							<td>${customer.emailID}</td>
						</tr>
					</c:forEach>
				</table>
			</font>
		</h5>
		<p>
			<a href="/mobilebilling/">Return To Home Page</a>
	</div>
</body>
</html>