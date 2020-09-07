<%@ page import = "java.util.*"%>
<%@ page import = "com.john.internship.model.Teams"%>
<%@ page import = "com.john.internship.connection.db.bean.TeamsBean"%>
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
          List<Teams> teams = new TeamsBean().show(dbConnection);

          %>
          <table class="table custom-table">
            <thead>
              <tr>
                <th>Team Name</th>
                <th>Team Code</th>
              </tr>
            </thead>
            <tbody>
              <%
              if(teams != null){
                for(Teams team:teams){
              %>
              <tr>
                <td><strong class="text-white"><%=team.getName()%></strong></td>
                <td><%=team.getCode()%></td>
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