<%@page import="com.cdac.dto.Manager"%>
<%@ include file="cache_control.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr"%>
    
    <%
	Manager manager = (Manager)session.getAttribute("manager");
	if(manager !=null && manager.getManagerId()>0)
	{
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Management Form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <style>
        .myclass {
            background: url(https://picsum.photos/id/307/1800/1000);
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
		<spr:form action="task_add.htm" method="post" commandName="management">
		<table align="center"> 
			 <tr>
				<td>
				Employee Id :
				</td>
				<td>
					<spr:label path="employeeId" />

				<select name="employeeId" id="employeeId">
  					<option value="1">1</option>
  					<option value="2">2</option>
  					<option value="3">3</option>
  					<option value="4">4</option>
  					<option value="4">5</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>
					Task Name :
				</td>
				<td>
					<spr:input path="manName" />
				</td>
			</tr>
			<tr>
				<td>
					Start Time :
				</td>
				<td>
					<spr:input path="manStartTime" />
				</td>
			</tr>
			<tr>
				<td>
					End Time :
				</td>
				<td>
					<spr:input path="manStopTime" />
				</td>
			</tr>
			<tr>
				<td>
					<a href="man_home.jsp">Back</a>
				</td>
				<td>
					<input type="submit" value="Add" >
				</td>
			</tr>
		</table>
		</spr:form>
		</div>
		</div>
</body>
</html>
<% 
	}
	else
	{
		response.sendRedirect("index.jsp");
	}
%>