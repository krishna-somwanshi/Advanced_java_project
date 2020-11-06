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
<title>Update Tasks</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <title>Document</title>
    <style>
        .myclass {
            background: url(https://picsum.photos/id/26/1800/1400);
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
	<spr:form action="task_update.htm" method="post" commandName="management">
		<table align="center">
			<%-- Taken for manually updation of employee id.--%>  
			 <tr>
				<td>
					
				</td>
				<td>		
					<spr:hidden path="manid"/>
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
					<a href="task_list_form.htm">Back</a>
				</td>
				<td>
					<input type="submit" value="Update" >
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