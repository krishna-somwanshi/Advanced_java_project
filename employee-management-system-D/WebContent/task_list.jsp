<%@page import="com.cdac.dto.Manager"%>
<%@page import="com.cdac.dto.Employee"%>
<%@page import="com.cdac.dto.Management"%>
<%@page import="java.util.List"%>
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
<title>Login Form for Employee</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
		
		<h1  class="text d-flex justify-content-center align-items-center padding">Task List</h1>
			<table class="table table-bordered text-light" bgcolor="black">
    <thead>
    <tr style="background: red;">
      <th scope="col">Employee Id</th>
      <th scope="col">task name</th>
      <th scope="col">start time</th>
      <th scope="col">end time</th>
      <th scope="col">Delete Task</th>
      <th scope="col" >Update Task</th>
   
    </tr>
  </thead>
	<tbody>
		<tr>
	     <% 
	     List<Management> tList = (List<Management>)request.getAttribute("tList");
			for(Management mng : tList){
		%>
	
		<td><%=mng.getEmployeeId()%></td>
		<td><%=mng.getManName()%></td>
		<td><%=mng.getManStartTime()%></td>
		<td><%=mng.getManStopTime()%></td>
	
		<td class="bg-danger">
<a  class="text-light d-flex justify-content-center align-items-center padding" href="task_delete.htm?manid=<%=mng.getManid()%>">
Delete
</a>
</td>
	<td class="bg-primary">
<a class="text-light d-flex justify-content-center align-items-center "href="task_update_form.htm?manid=<%=mng.getManid()%>">
Update
</a>
</td>
	</tr>
	<%}%>
	</tbody>
	</table>
	
	</table> 
			<table class="text-light d-flex justify-content-center align-items-center">
			<tr>
				<td>
					<a href="man_home.jsp">Back</a>
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