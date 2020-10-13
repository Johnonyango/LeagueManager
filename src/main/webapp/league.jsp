
<!DOCTYPE html>
<html lang="en">
<%@ include file = "header.jsp"%>

<html>
<body>
  <%@ include file = "header.html"%>
  <%@ include file = "background.jsp"%>


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
                <th>Country</th>
                <th>Level</th>
                <th>Season</th>
              </tr>
            </thead>
            <tbody id="league">

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
    $.getJSON('League', function(data){
      var content = '';
      for(var i = 0; i<data.length; i++){
        var league = data[i];
        content+=`<tr>
                    <td><strong class="text-white">${league.leagueName}</strong></td>
                    <td<strong class="text-white">${league.country}</td>
                    <td <strong class="text-white">${league.level}</td>
                    <td <strong class="text-white">${league.leagueId}</td>
                  </tr>`;
      }
      $('#league').html(content);
    });
</script>
</body>
</html>