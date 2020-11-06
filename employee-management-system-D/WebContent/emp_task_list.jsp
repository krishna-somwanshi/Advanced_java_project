<%@page import="com.cdac.dto.Employee"%>
<%@ include file="cache_control.jsp" %>
<%@page import="com.cdac.dto.Management"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%	
	 Employee employee = (Employee)session.getAttribute("employee");
	if(employee !=null && employee.getEmployeeId()>0)
	{
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Task Information</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
		<h1  class="text d-flex justify-content-center align-items-center padding">Task List</h1>
			<table class="table table-bordered text-light" bgcolor="DodgerBlue">
    <thead>
    <tr>
      
      <th scope="col" style="background-color: black;">task name</th>
      <th scope="col" style="background-color: black;">start time</th>
      <th scope="col" style="background-color: black;">end time</th>
   
    </tr>
  </thead>
	<tbody>
		<tr>
	
		<%
			List<Management> tList = (List<Management>)request.getAttribute("tList");
			for(Management mng : tList){
		%>
			<tr>
				<td><%=mng.getManName()%></td>
				<td><%=mng.getManStartTime()%></td>
				<td><%=mng.getManStopTime()%></td>
			</tr>
			</tbody>
	</table>
	<%}%>
	
			<table class="text-light d-flex justify-content-center align-items-center">
			<tr>
				<td>
					<a href="home.jsp">Back</a>
				</td>
			</tr>
		</table>

</body>	
</html>
<% 
	}
	else
	{
		response.sendRedirect("index.jsp");
	}
%>