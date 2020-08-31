<% session.invalidate();%>
<%
HttpSession nsession = request.getSession(false);
if(nsession!=null) {
String data=(String)session.getAttribute( "fname" );
out.println(data);
}
else
out.println("Session is not active");
%>