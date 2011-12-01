<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Employee List</title>
		<style type="text/css">
		body {
			font-family: Trebuchet MS, Verdana;
			font-size: 12px;
		}
		</style>
	</head>
	<body>
		<h1>Employee Org Chart <img src="cloud.jpg"></h1>
		<table border="2">
				<tr>
					<th>First Name</th>
					<th>Last Name </th>
					<th>Job Title  </th>
					<th>Employee ID </th>
					<th>Department </th>
					<th>Phone Extn. </th>
				</tr>
			<c:forEach var="employee" items="${employees}" varStatus="count">
				<tr >
					<td>${employee.firstName}</td>
					<td>${employee.lastName}</td>
					<td>${employee.jobTitle}</td>
					<td>${employee.employeeId}</td>
					<td>${employee.department}</td>
					<td>${employee.phoneExtn}</td>
				</tr>
			</c:forEach>
		</table>	
		<br>
		<form action="donedetails.html" method="get">
		<input type="submit" value="Back to Home Page">
		</form>
	</body>
</html>

