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
		<img src="cloud.jpg">

		<form action="newdetails.html" method="post" >
			<b>Employee Details:<br></b>
			<b>First Name:</b> <input type="text" name="firstname"><br>
			<b>Last  Name:</b> <input type="text" name="lastname"><br>
			<b>Job Title:</b><input type="text" name="jobtitle" ><br>
			<b>Department:</b><input type="text" name="department" ><br>
			<b>Salary:</b><input type="text" name="salary" ><br>
			<input type="reset" value="Reset">
			<input type="submit" value="Submit">
		</form>
	</body>
</html>