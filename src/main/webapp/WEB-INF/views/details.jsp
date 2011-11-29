<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>New Employee Input</title>
		<style type="text/css">
		body {
			font-family: Trebuchet MS, Verdana;
			font-size: 12px;
		}
		</style>
	</head>
	<body>
		<h1>Employee Details<img src="cloud.jpg"></h1>
		

	<table border="1">
	<tr>
		<th>Header 1</th>
		<th>Header 2</th>
	</tr>
	<tr>
		<td><b>First Name</b></td>
		<td>${employee.firstName}</td>
	</tr>
	<tr>
		<td><b>Last Name</b></td>
		<td>${employee.lastName}</td>
	</tr>	
	<tr>
		<td><b>Job Title</b></td>
		<td>${employee.jobTitle}</td>
	</tr>	
	<tr>
		<td><b>Employee ID</b></td>
		<td>${employee.employeeId}</td>
	</tr>	
	<tr>
		<td><b>Department</b></td>
		<td>${employee.department}</td>
	</tr>	
	<tr>
		<td><b>Phone Extn</b></td>
		<td>${employee.phoneExtn}</td>
	</tr>
	<br>
</table><p>
	
	</p><form action="donedetails.html" method="get">
		<input type="submit" value="Back to Home Page">
		</form>
	</body>
</html>