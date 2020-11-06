<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form for Employee</title>
<meta charset="ISO-8859-1">
<title>Login Form for Employee</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <style>
        .myclass {
            background: url(https://picsum.photos/id/2/1400/1200);
        }
    </style>
</head>
<body>
<div class="container-fluid myclass text-light">
        <div class="row" style="height: 100vh;">
            <!-- <div class="col">A</div> -->
            <div class="col d-flex justify-content-center align-items-center">
                <div class="row d-flex flex-column shadow-lg rounded"
                    style="padding: 100px; border: 1px solid rgb(187, 175, 169);">
                    <!-- Login Box -->
                    <h1 style="color: DodgerBlue;">Employee Registration</h1><br>

	<spr:form action="reg.htm" method="post" commandName="employee">
		<table align="center">
			<tr>
				<td>
				<FONT color="" font-size="25px">
					<p style="font-weight:bold"">	
					Employee Name :
				</td>
				<td>
					<spr:input path="employeeName" />
					<FONT color="red">
					<spr:errors path="employeeName"></spr:errors>
				</td>
			</tr>
			<tr>
				<td>
				<FONT color="" font-size="25px">
					<p style="font-weight:bold"">	
					Employee E-mail :
				</td>
				<td>
					<spr:input path="employeeEmail" />
					<FONT color="red">
					<spr:errors path="employeeEmail"></spr:errors>
				</td>
			</tr>
			<tr>
				<td>
				<FONT color="" font-size="25px">
					<p style="font-weight:bold"">	
					Employee Password
				</td>
				<td>
					<spr:password path="employeePass" />
					<FONT color="red">
					<spr:errors path="employeePass"></spr:errors>
				</td>
			</tr>
			
			
				<td>
					<a href="index.jsp">Back</a>
				</td>
				<td>
					<input type="submit" value="Register" >
				</td>
			</tr>
		</table>
		</spr:form>
		
		    </div>
            </div>
		
</body>
</html>