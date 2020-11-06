<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr"%>
      
<%
	String unm = "";
	Cookie arr[] = request.getCookies();
	if(arr!=null){
		for(Cookie a : arr){
			String cname = a.getName();
			if(cname.equals("managerName")){
				unm = a.getValue();
				break;
			}
		}
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form for Manager</title>
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
        <div class="row" style="height: 100vh;">
            <!-- <div class="col">A</div> -->
            <div class="col d-flex justify-content-center align-items-center">
                <div class="row d-flex flex-column shadow-lg rounded"
                    style="padding: 100px; border: 1px solid rgb(187, 175, 169);">
                    <!-- Login Box -->
                    <h1 style="font-weight:bold; color:blue;">Manager Login</h1><br>


	<spr:form action="login1.htm" method="post" commandName="manager">
		<table align="center">
			<tr>
				<td>
				<FONT color="" font-size="25px">
					<p style="font-weight:bold; color:blue;">	
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
				<FONT color="" font-size="25px">
					<p style="font-weight:bold; color:blue;">	
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
					<h1 style="font-size:20px; color:blue;"><a href="index.jsp">Back</a></h1>
				</td>
				<td>
					<input type="submit" value="Login" >
				</td>
			</tr>
		</table>
		</spr:form>
		    </div>
            </div>
</body>
</html>