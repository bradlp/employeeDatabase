<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
	<head>
		<title>Error on Request</title>
		<style type="text/css">
		body {
			font-family: Trebuchet MS, Verdana;
			font-size: 12px;
		}
		</style>
	</head>
	<body>
		<h1>Employee Database<img src="cloud.jpg"></h1><br>
		<b>There was an error processing your request.<br>
		More details of your error are shown below, the link below will return you to the home page.</b> 
   	<br>	
	<table border="1">
	<tr>
		<th>Error Code</th>
		<th>Error Detail</th>
		<th>Hint</th>
	</tr>
	<tr>
		<td>${errorcode}</td>
		<c:choose>
      	<c:when test="${errorcode=='1'}">
      		<td>No Employees in the Database.</td>
      		<td>Please contact HR on your login account.</td>
      	</c:when>
      	<c:when test="${errorcode=='2'}">
      		<td>The Employee Name was not found.</td>
      		<td>Please try again, ensure you typed the name correctly.</td>
      	</c:when>
      	<c:when test="${errorcode=='3'}">
      		<td>The Employee ID was not found.</td>
      		<td>Please try again, ensure you have the correct ID.</td>
      	</c:when>
      	<c:when test="${errorcode=='4'}">
      		<td>This Employee already exists.</td>
      		<td>Check with HR Director, another manager may have already entered this employee.</td>
      	</c:when>
      	<c:otherwise>
      		<td>Error processing your request.</td>
      		<td>Please contact the website administrator, ask HR for details.</td>
      	</c:otherwise>
    	</c:choose>	
   	
	</tr>
	</table>
	
	</p><form action="errorCodes.html" method="get">
		<input type="submit" value="Back to Home Page">
		</form>
	</body>
</html>