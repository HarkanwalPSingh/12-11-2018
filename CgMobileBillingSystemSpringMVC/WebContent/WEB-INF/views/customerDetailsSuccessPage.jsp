<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details</title>
</head>
<body>

<div align="left">
		<h5 align="center">
			<font color="brown" size="4">
			customerID : ${customer.customerID}<br>
			firstName : ${customer.firstName}<br>
			lastName : ${customer.lastName}<br>
			emailID : ${customer.emailID}<br>
			dateOfBirth : ${customer.dateOfBirth}<br>
			pinCode : ${customer.billingAddress.pinCode}<br>
			city : ${customer.billingAddress.city}<br>
			state : ${customer.billingAddress.state}<br>
			 </font>
		</h5>
		<p>
			<a href="/mobilebilling/">Return To Home Page</a>
	</div>
</body>
</html>