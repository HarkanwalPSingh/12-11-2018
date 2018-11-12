<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Plan Details</title>
</head>
<body>
<div align="left">
		<h5 align="center">
			<font color="brown" size="4"> Plan Details	</font>
				<table border="1" align="center">
					<tr>
						<th>planID</th>
						<th>monthlyRental</th>
						<th>freeLocalCalls</th>
						<th>freeStdCalls</th>
						<th>freeLocalSMS</th>
						<th>freeStdSMS</th>
						<th>freeInternetDataUsageUnits</th>
						<th>localCallRate</th>
						<th>stdCallRate</th>
						<th>localSMSRate</th>
						<th>stdSMSRate</th>
						<th>internetDataUsageRate</th>
						<th>planCircle</th>
						<th>planName</th>
					</tr>
					<c:forEach items="${plans}" var="plan">
						<tr>
							<td>${plan.planID}</td>
							<td>${plan.monthlyRental}</td>
							<td>${plan.freeLocalCalls}</td>
							<td>${plan.freeStdCalls}</td>
							<td>${plan.freeLocalSMS}</td>
							<td>${plan.freeStdSMS}</td>
							<td>${plan.freeInternetDataUsageUnits}</td>
							<td>${plan.localCallRate}</td>
							<td>${plan.stdCallRate}</td>
							<td>${plan.localSMSRate}</td>
							<td>${plan.stdSMSRate}</td>
							<td>${plan.internetDataUsageRate}</td>
							<td>${plan.planCircle}</td>
							<td>${plan.planName}</td>
						</tr>
					</c:forEach>
				</table>
			
		</h5>
		<p>
			<a href="/mobilebilling/">Return To Home Page</a>
	</div>
</body>
</html>