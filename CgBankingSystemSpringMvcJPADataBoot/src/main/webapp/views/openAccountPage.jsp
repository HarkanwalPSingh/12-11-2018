<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Open Account</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	
<h1>Enter Account Details</h1>
	<table border=1>
		<form:form action="registerAccount" method="post"
			modelAttribute="account">
			<tr>
				<td>Account Type:</td>
				<%-- <td><form:radiobutton path="accountType" value="Savings" /> 
					<form:radiobutton	path="accountType" value="Current" /></td>
					<td><form:errors path="accountType" cssClass="error" /></td> --%>
				<td><form:input path="accountType" size="25" /></td>
				<td><form:errors path="accountType" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Initial Balance:</td>
				<td><form:input path="accountBalance" size="25" /></td>
				<td><form:errors path="accountBalance" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="Submit"
					name="submit" value="Submit"></td>
			</tr>
		</form:form>
	</table>
</body>
</html>