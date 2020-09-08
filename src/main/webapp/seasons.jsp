<%@ page import = "java.util.*"%>
<%@ page import = "com.john.internship.model.Seasons"%>
<%@ page import = "com.john.internship.connection.db.bean.SeasonsBean"%>
<%@ page import = "java.sql.Connection"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file = "header.jsp"%>

<html>
<body>
  <%@ include file = "header.html"%>

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
          List<Seasons> seasons = new SeasonsBean().show(dbConnection);

          %>
          <table class="table custom-table">
            <thead>
              <tr>
                <th>From Date</th>
                <th>To Date</th>
                <th>Status</th>
              </tr>
            </thead>
            <tbody>
              <%
              if(seasons != null){
                for(Seasons season:seasons){
              %>
              <tr>
                <td><strong class="text-white"><%=season.getFromYear()%></strong></td>
                <td><%=season.getToYear()%></td>
                <td><%=season.getStatus()%></td>
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