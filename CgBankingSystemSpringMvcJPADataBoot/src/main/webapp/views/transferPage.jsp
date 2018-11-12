<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fund Transfer</title>
</head>
<body>
	<div align="center">
		<form action="transferFunds" method="post">
			<table border=1>
				<tr>
					<td>Enter Your Account Number</td>
					<td><input type="text" name="accountNumberFrom" size="25" /></td>
				</tr>
				<tr>
					<td>Enter Beneficiary's Account Number</td>
					<td><input type="text" name="accountNumberTo" size="25" /></td>
				</tr>
				<tr>
					<td>Enter your PIN Number</td>
					<td><input type="password" name="pinNumber" size="25" /></td>
				</tr>
				<tr>
					<td>Enter Amount</td>
					<td><input type="text" name="amount" size="25" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="Submit"
						name="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>
	<p>
		<a href="/banking">Return To Home Page</a>
</body>
</html>