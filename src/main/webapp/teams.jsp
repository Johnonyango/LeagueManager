
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

          <table class="table custom-table">
            <thead>
              <tr>
                <th>Name</th>
                <th>Code</th>
                <th>League</th>
                <th>Action</th>
              </tr>

            </thead>
            <tbody id="team">

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
    $.getJSON('Teams', function(data){
      var content = '';
      for(var i = 0; i<data.length; i++){
        var teamsTable = data[i];
        content+=`<tr>
                    <td><strong class="text-white">${teamsTable.name}</strong></td>
                    <td>${teamsTable.code}</td>
                    <td>${teamsTable.leagueName}</td>
                     <td>${teamsTable.action}</td>
                  </tr>`;
      }
      $('#team').html(content);
    });
</script>
</body>
</html>