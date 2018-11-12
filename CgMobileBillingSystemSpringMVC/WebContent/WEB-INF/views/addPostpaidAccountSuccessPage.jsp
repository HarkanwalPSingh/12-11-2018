<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post-paid Account Page</title>
</head>
<body>
	<div align="left">
		<h5 align="center">
			<font color="brown" size="4">
			Post-paid Account successfully added for the CustomerID: ${postpaidAccount.customer.customerID}<br>
			Assigned Mobile number: ${postpaidAccount.mobileNo}<br>
			Chosen Plan: ${postpaidAccount.plan.planName}		
			 </font>
		</h5>
		<p>
			<a href="addPostpaidAccount">Open new Postpaid Account</a>		
		<p>
			<a href="/mobilebilling/">Return To Home Page</a>
	</div>
</body>
</html>