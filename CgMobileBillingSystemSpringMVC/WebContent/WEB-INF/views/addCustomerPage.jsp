<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Customer</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>

	<div align=center>
		<h1>Welcome to Mobile Billing</h1>
		<br>
		<h1>Enter Customer Details</h1>
		<table border=1>
			<form:form action="registerCustomer" method="post"
				modelAttribute="customer">
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName" size="25" /></td>
					<td><form:errors path="firstName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" size="25" /></td>
					<td><form:errors path="lastName" cssClass="error" /></td>
				</tr>
				<tr>
				<tr>
					<td>e-Mail ID:</td>
					<td><form:input path="emailID" size="25" /></td>
					<td><form:errors path="emailID" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Date Of Birth:</td>
					<td><form:input path="dateOfBirth" size="25" /></td>
					<td><form:errors path="dateOfBirth" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Pin Code:</td>
					<td><form:input path="billingAddress.pinCode" size="25" /></td>
					<td><form:errors path="billingAddress.pinCode"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><form:input path="billingAddress.city" size="25" /></td>
					<td><form:errors path="billingAddress.city" cssClass="error" /></td>
				</tr>
				<tr>
				<tr>
					<td>State:</td>
					<td><form:input path="billingAddress.state" size="25" /></td>
					<td><form:errors path="billingAddress.state" cssClass="error" /></td>
				</tr>
				<tr>
				<td colspan="2" align="center"><input type="Submit"
					name="submit" value="Submit"></td>
				</tr>
			</form:form>
		</table>

	</div>


</body>
</html>