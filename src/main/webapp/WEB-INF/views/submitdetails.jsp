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
		<h1>Employee Details</h1>
		<img src="../cloud.jpg">

		<form action="newdetails.html" method="post" >
					
			<b>Employee Details:<br></b>
			<table border="0">
				<tr>
					<td><b>First Name</b></td>
					<td> <input type="text" name="firstname"></td>
				</tr>
				<tr>
					<td><b>Last  Name:</b></td>
					<td><input type="text" name="lastname"><br></td>		
				</tr>
				<tr>
					<td><b>Job Title:</b></td>
					<td><input type="text" name="jobtitle" ><br></td>
				</tr>
				<tr>
					<td><b>Department:</b></td>
					<td><input type="text" name="department" ><br></td>
				</tr>
				<tr>
					<td><b>Salary:</b></td>
					<td><input type="text" name="salary" ><br></td>
				</tr>
				</table>
			
			<input type="reset" value="Reset">
			<input type="submit" value="Submit">
			
			
				
		</form>
	</body>
</html>