
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
                <th>ID</th>
                <th>From</th>
                <th>To</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody id="seasons">

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
    $.getJSON('Seasons', function(data){
      var content = '';
      for(var i = 0; i<data.length; i++){
        var seasons = data[i];
        content+=`<tr>
                    <td><strong class="text-white">${seasons.id}</strong></td>
                    <td>${seasons.fromYear}</td>
                    <td>${seasons.toYear}</td>
                    <td>${leagueTable.action}</td>
                  </tr>`;
      }
      $('#seasons').html(content);
    });
</script>
</body>
</html>