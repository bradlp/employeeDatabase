<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
	<tr>
		<td><b>Salary</b>
		<c:choose>
      	<c:when test="${secure==true}">
      		<td>${employee.salary}.</td>
      	</c:when>
      	<c:otherwise>
      		<td><font color="red"> <b>Not Availible</b></font></td>
      	</c:otherwise>
		</c:choose>
	</tr>
</table><p>
	
	</p><form action="donedetails.html" method="get">
		<input type="submit" value="Back to Home Page">
		</form>
		
	</body>
</html>