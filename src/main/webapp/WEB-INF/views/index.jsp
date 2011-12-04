<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

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
			<td style="background-color: #FFFFFF;" width="50%">
				<table>
					<tr>
						<td style="background-color: #FFFFFF;" colspan="2">

							<h3>Employee Database Lookup.</h3>
							
							Welcome <font color="blue" > <b><security:authentication property="principal.username"/> </b> </font> to the Online Employee DataBase<br>
							You can lookup and find all you Co-Workers quickly and easily.<br> 
							Please logout when done. <font color="blue" > <a href="j_spring_security_logout"> Logout <security:authentication property="principal.username"/></a> </font>
		    				<br>
		    				<hr>
							<b>Current Company Employee Count </b> (total: ${employeeCount})<br>
							<hr>
		    				<b>List all Employees : </b><br> 
							<form action="listAll.html" method="get">
									<input type="submit" value="List All" />
							</form> 
							<hr>
							<b>List all Employees by Department:</b><br>
							<form action="listByDepartment.html" method="get">

								<INPUT TYPE=RADIO NAME=department VALUE="ALL" CHECKED>ALL<BR>
								<INPUT TYPE=RADIO NAME=department VALUE="Engineering">Engineering Department<BR>
								<INPUT TYPE=RADIO NAME=department VALUE="Sofware">Software Department<BR>
								<INPUT TYPE=RADIO NAME=department VALUE="Test">Test Department<BR>
								<INPUT TYPE=RADIO NAME=department VALUE="Finance">Finance Department<BR>
								<INPUT TYPE=RADIO NAME=department VALUE="HR">HR Department<BR>
								<INPUT TYPE=RADIO NAME=department VALUE="IT">IT Department<BR>
							<input type="submit" value="List By Department">
							</form>

							<form action="findEmployeeByName.html" method="get">
									<b>Find Employee Details by Name:</b><br> 
									First Name: <input type="text" name="firstname" /><br>
									Last  Name: <input type="text" name="lastname" /><br>
									<input type="submit" value="FindBy Name">
							</form>
							<form action="findEmployeeByID.html" method="get">
									<b>Find Employee Details by Employee ID:</b><br> 
									Employee ID: <input type=int name="employeeID" /><br>
									<input type="submit" value="Find By ID">
							</form>
							</td>
					</tr>
				</table>
			</td>
			<td style="background-color: #FFFFFF;" width="50%">

				<table width="60%" height="60%" align="center">
					<tr>
						<td style="background-color: #CCCCCC;" colspan="2">
							<h2 style="color:red"> Rescricted Access </h2>
							Manager and HR Administrators Only in this area.
							Secure Login is Required will be required

							<form action="secure/addnew.html" method="get">
									Employee Details:<br> New Employee Page: 
									<input type="submit" value="Add New Employee" />
							</form>
							<br>
							<hr>
							<form action="secure/findEmployeeSalary.html" method="get">
									<b>Find Employee Salary:</b><br> 
									First Name: <input type="text" name="firstname" /><br>
									Last  Name: <input type="text" name="lastname" /><br>
									<input type="submit" value="Find Employee Salary">
							</form>
							<br>
							<hr>
							<form action="secure/findEmployeePerfomance.html" method="get">
									<b>Find Employee Salary:</b><br> 
									First Name: <input type="text" name="firstname" /><br>
									Last  Name: <input type="text" name="lastname" /><br>
									<input type="submit" value="Find Employee Rating">
							</form>
							
						</td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>

</html>




