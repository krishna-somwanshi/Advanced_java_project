<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form For Manager</title>
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
                    <h1>Manager Registration</h1><br>

	<spr:form action="reg1.htm" method="post" commandName="manager">
		<table align="center">
			<tr>
				<td>
					Manager Name :
				</td>
				<td>
					<spr:input path="managerName" />
						<FONT color="red">
					<spr:errors path="managerName"></spr:errors>
				</td>
			</tr>
			<tr>
				<td>
					M Password
				</td>
				<td>
					<spr:password path="managerPass" />
						<FONT color="red">
					<spr:errors path="managerPass"></spr:errors>
				</td>
			</tr>
			<tr>
				<td>
					<a href="index.jsp">Back</a>
				</td>
				<td>
					<input type="submit" value="Register" >
				</td>
			</tr>
		</table>
		</spr:form>
</body>
</html>