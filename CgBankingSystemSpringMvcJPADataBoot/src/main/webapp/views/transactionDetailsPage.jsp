<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="left">
		<h5 align="center">
			<font color="brown" size="4"> Details of Transaction are as
				given below.
				<table border="1">
					<tr>
						<th>TransactionId</th>
						<th>Amount</th>
						<th>Transaction Type</th>
					</tr>
					<c:forEach items="${transactions}" var="transaction">
						<tr>
							<td>${transaction.transactionId}</td>
							<td>${transaction.amount}</td>
							<td>${transaction.transactionType}</td>
						</tr>
					</c:forEach>
				</table>
			</font>
		</h5>
		<p>
			<a href="/banking">Return To Home Page</a>
	</div>
</body>
</html>