<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form for Employee</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <style>
        .myclass {
            background: url(https://picsum.photos/id/201/1400/800);
        }
    </style>
</head>
<body>
    <div class="container-fluid myclass text-light">
        <div class="row" style="height: 100vh; color: red;">
            <!-- <div class="col">A</div> -->
            <div class="col d-flex justify-content-center align-items-center">
                <div class="row d-flex flex-column"
                    style="padding: 100px;">
                    <!-- Login Box -->
                    <h1>Employee Login</h1><br>
                    
                    <spr:form action="login.htm" method="post" commandName="employee">
		<table align="center">
			<tr>
				<td>
					<FONT color="" font-size="25px">
					<p style="font-weight:bold"">			
					UserName : 
					</p>
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
					Password :
					</p>
				</td>
				<td>
					<spr:password path="employeePass" />
					<FONT color="red">
					<spr:errors path="employeePass"></spr:errors>
				</td>
			</tr>
			<tr>
				<td>
				<FONT color="" font-size="25px">
					<a href="index.jsp" style=" color:black; font-size:25px"">
					Back</a>
				</td>
				<td>
					<input type="submit" value="Login" >
				</td>
			</tr>
		</table>
		</spr:form>
                </div>
            </div>
            <!-- <div class="col">A</div> -->
        </div>
    </div>
<%-- 	<spr:form action="login.htm" method="post" commandName="employee">
		<table align="center">
			<tr>
				<td>
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
					E Password
				</td>
				<td>
					<spr:password path="employeePass" />
					<FONT color="red">
					<spr:errors path="employeePass"></spr:errors>
				</td>
			</tr>
			<tr>
				<td>
					<a href="index.jsp">Back</a>
				</td>
				<td>
					<input type="submit" value="Login" >
				</td>
			</tr>
		</table>
		</spr:form>
		--%>
</body>
</html>