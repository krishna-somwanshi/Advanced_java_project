<%
	session.removeAttribute("manager");
	session.invalidate();
	response.sendRedirect("index.jsp");
%>