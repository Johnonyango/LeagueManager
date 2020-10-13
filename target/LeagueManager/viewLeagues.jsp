
<!DOCTYPE html>
<html lang="en">
<%@ include file = "header.jsp"%>

<html>
<body>
  <%@ include file = "header.html"%>
  <%@ include file = "background.jsp"%>
  
  <%
  String id = request.getParameter("id");
  %>

<div class="site-wrap">
    <div class="site-section bg-dark">
        <div class="container">
          <div class="row">
            <div class="col-lg-1">
            </div>
    <div class="col-lg-10">

        <div class="widget-next-match">

          <table class="table custom-table">
            <thead>
              <tr>
                <th>P</th>
                <th>Name</th>
                <th>PW</th>
                <th>Points</th>
              </tr>
            </thead>
            <tbody id="table">

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
<%@ include file = "sitewrap.jsp"%>

<!-- <script src="js/league.js"></script> -->
<script>

function load(){

$.getJSON('./rest/table/findTableByLeagueId/<%= id%>', function(data){
  var content = '';
  for(var i = 0; i<data.length; i++){
    var leagueTable = data[i];
    content+=`<tr>
                <td>${i+1}</td>
                <td><strong class="text-white">${leagueTable.name}</strong></td>
                <td <strong class="text-white" >${leagueTable.numberOfGames}</td>
                <td <strong class="text-white">${leagueTable.points}</td>
              </tr>`;
  }
  $('#table').html(content);
});
              }
              load();
    // $.getJSON('League', function(data){
    //   var content = '';
    //   for(var i = 0; i<data.length; i++){
    //     var league = data[i];
    //     content+=`<tr>
    //                 <td><strong class="text-white">${league.leagueName}</strong></td>
    //                 <td>${league.country}</td>
    //                 <td>${league.level}</td>
    //                 <td>${league.leagueId}</td>
    //               </tr>`;
    //   }
    //   $('#league').html(content);
    // });
</script>
</body>
</html>