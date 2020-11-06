<%
	session.removeAttribute("employee");
	session.invalidate();
	response.sendRedirect("index.jsp");
%>