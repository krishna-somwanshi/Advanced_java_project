<%@page import="com.cdac.dto.Manager"%>
<%@ include file="cache_control.jsp" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%	
	Manager manager = (Manager)session.getAttribute("manager");
	if(manager !=null && manager.getManagerId()>0)
	{
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%-- <title>Employee Management System</title>  --%>
<title>Home Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <style>
        .myclass {
            background: url(https://picsum.photos/id/1/1800/1000);
        }
    </style>
</head>
<body>
	<div class="container-fluid myclass text-light">
	<h1 style="margin-left: 300px ">Welcome To Task Manager</h1>
        <div class="row" style="height: 100vh;">
            <!-- <div class="col">A</div> -->
            <div class="col d-flex justify-content-center align-items-center">
                <div class="row d-flex flex-column rounded"
                    style="padding: 100px;">
	<table align="center">
		<tr>
			<td> Welcome <%=(session.getAttribute("manager")!=null) ? 
			((Manager)session.getAttribute("manager")).getManagerName() : "!!!!!!!!" %> </td>
		</tr>
		<tr>
			<td><h3><a href="assign_task_form.htm">Assign Task</a></h3></td>
			
		</tr>
		<tr>
			<td><h3><a href="task_list_form.htm">Employee List</a></h3></td>
		</tr>
		<tr>
			<td><h3><a href="logout_man.jsp">Logout</a></h3></td>
		</tr>
		</table>
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