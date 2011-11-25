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
		<img src="springsource.png">

		<form method="post" >
			Employee Details:<br>
			First Name: <input type="text" name="firstname"/><br />
			Last  Name: <input type="text" name="lastname"/><br />
			Job Title: <input type="text" name="jobtitle"/><br />
			<input type="reset" value="Reset">
			<input type="submit"value="Submit">
		</form>
	</body>
</html>