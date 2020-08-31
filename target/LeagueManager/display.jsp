<%@ page import = "java.util.*, com.john.internship.connection.db.*"%>
<%=session.getAttribute("fname")%>
<%=session.getAttribute("lname")%>
<%=session.getAttribute("hisAge")%>
<%=session.getAttribute("hisAddress")%>


<%Enumeration e= application.getAttributeNames();%>
<%out.println(e.toString());%>

<%
String sname=config.getServletName();
out.print("Servlet Name is: "+sname);
%>


