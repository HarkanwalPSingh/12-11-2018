<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Post-paid Account</title>
</head>
<body>
<div align="center">
		<form action="registerPostpaidAccount" method="post">
			<table border=1>
				<tr>
					<td>Enter Customer ID</td>
					<td><input type="text" name="customerID" size="25" /></td>
				</tr> 
				<tr>
					<td>Select Plan ID:</td>
					<td>
					<input type="radio"  name="planID" value="101" size="25">Violet Base(101)
					<input type="radio" name="planID" value="102" size="25">Violet Entertainment(102)
					<input type="radio" name="planID" value="103" size="25">Violet Entertainment+(103)
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="Submit"
						name="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
		<a href="getplanDetails">Get All Plan Details</a>
	</div>
	
</body>
</html>