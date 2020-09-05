<%@ page import = "java.util.*"%>
<%@ page import = "com.john.internship.model.League"%>
<%@ page import = "com.john.internship.connection.db.bean.LeagueBean"%>
<%@ page import = "java.sql.Connection"%>
<!DOCTYPE html>
<html>
<%@ include file = "page/header.html"%>
<body>
<%@ include file = "page/navbar.jsp"%>
<%
String searchLeague = request.getParameter("searchLeague");
if (searchLeague != null){

Connection dbConnection = (Connection) getServletContext().getAttribute("dbConnection");
League league = new LeagueBean().search(dbConnection, searchLeague);
if(league != null){
%>
'</br>'+ name: <%= league.getName()%>
country: <%= league.getCountry()%>
level: <%= league.getLevel()%> '</br>'
<%
}
}
%>
<div id="module-content">

</div>

<script src="js/league.js"></script>
</body>
</html>