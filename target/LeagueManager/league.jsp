
<%@ page import = "java.util.*"%>
<%@ page import = "com.john.internship.model.League"%>
<%@ page import = "com.john.internship.connection.db.bean.LeagueBean"%>
<%@ page import = "java.sql.Connection"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file = "header.jsp"%>

<html>
<body>
<div class="site-wrap">
    <div class="site-section bg-dark">
        <div class="container">
          <div class="row">
            <div class="col-lg-1">
            </div>
    <div class="col-lg-10">

        <div class="widget-next-match">
          <%
          Connection dbConnection = (Connection) getServletContext().getAttribute("dbConnection");
          List<League> leagues = new LeagueBean().show(dbConnection);

          %>
          <table class="table custom-table">
            <thead>
              <tr>
                <th>Name</th>
                <th>Country</th>
                <th>Level</th>
              </tr>
            </thead>
            <tbody>
              <%
              if(leagues != null){
                for(League league:leagues){
              %>
              <tr>
                <td><strong class="text-white"><%=league.getName()%></strong></td>
                <td><%=league.getCountry()%></td>
                <td><%=league.getLevel()%></td>
              </tr>
              <%
            }
          }
              %>
            </tbody>
          </table>
        </div>

      </div>
      <div class="col-lg-1">
    </div>
  </div>
</div>
</div> <!-- .site-section -->
</div>
<!-- <script src="js/league.js"></script> -->
</body>
</html>