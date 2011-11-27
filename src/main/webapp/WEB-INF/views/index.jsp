<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<head>
<title>Employee Database </title>
</head>

<head>
<title>Employee Database</title>
<style type="text/css">
body {
	font-family: Trebuchet MS, Verdana;
	font-size: 12px;
}
</style>
</head>


<body>
	<table width="100%" height="100%">

		<tr>
			<td style="background-color:#FFFFFF;" height="20">
				<table>
					<tr>
						<td><h2>The Cloud Company Ltd.</h2> </td>
						<td><img src="cloud.jpg" alt="The Cloud Company Ltd."></td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr>
			<td style="background-color: #00FFFF;" width="50%">
				<table>
					<tr>
						<td style="background-color: #FFFFFF;" colspan="2">

							<h2>Employee Database Lookup.</h2>
							<b>Current Company Employee Count </b>(total: ${employeeCount})<br>
							<hr>
							<b>List all Employees:</b><br> 
							<form action="listAll.html" method="get">
									<input type="submit" value="List All" />
									<input type="submit" value="List By department" />
							</form> 
							<b>List all Employees by Department:</b><br>
							<form action="listAll.html" method="get">

								<INPUT TYPE=RADIO NAME=age VALUE="?" CHECKED>unspecified<BR>
								<INPUT TYPE=RADIO NAME=age VALUE="0-12">0-12 years<BR>
								<INPUT TYPE=RADIO NAME=age VALUE="13-17">13-17 years<BR>
								<INPUT TYPE=RADIO NAME=age VALUE="18-25">18-25 years<BR>
								<INPUT TYPE=RADIO NAME=age VALUE="26-35">26-35 years<BR>
								<INPUT TYPE=RADIO NAME=age VALUE="36-">36 or more years<BR>
							<input type="submit" value="ListByDepartment">
							</form>

							<form action="findEmployee.html" method="get">
									<b>Find Employee Details:</b><br> 
									First Name: <input type="text" name="firstname" /><br>
									Last  Name: <input type="text" name="lastname" /><br>
									<input type="submit" value="Find">
								</form>
								
						</td>
					</tr>
				</table>
			</td>
			<td style="background-color: 00FFFF;" width="50%">

				<table width="60%" height="60%" align="center">
					<tr>
						<td style="background-color: #CCCCCC;" colspan="2">
							<h2 style="color:red"> Rescrited Access </h2>
							Manager Only in this area.
							Login will be required
							<form name="input"  method="get">
								Username: <input type="text" name="user" /><br>
								Password: <input type="text" type="hidden" name="user" /><br>
								<input type="submit" value="Login" />
							</form>
							<form method="post">
									Employee Details:<br> New Employee Page: <input
										type="text" name="firstname" /><br /> 
										<input type="reset"	value="Reset" /> <input type="submit" value="Submit" />
							</form>
												
							
						</td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>

</html>

<!--<table>
	<c:forEach var="employee" items="${employees}"
		varStatus="index">
		<tr>
			<td>${employee.firstName}</td>
			<td>${employee.lastName}</td>
		</tr>
	</c:forEach>
</table>  -->

