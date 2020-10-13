
<!DOCTYPE html>
<html lang="en">
<%@ include file = "includes/header.jsp"%>
<body class="hold-transition sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
<div class="wrapper">
  <!-- Navbar -->
  <%@ include file = "includes/navbar.jsp"%>

  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <%@ include file = "includes/main-sidenav.jsp"%>


  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-md-12">
           <!-- <form action="">
              <h1>Team A</h1>
            <select class="browser-default custom-select" id="teamA"></select>
            <select class="browser-default custom-select">
              <option selected>Score</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="1">4</option>
              <option value="2">5</option>
              <option value="3">6</option>
              <option value="2">7</option>
              <option value="3">8</option>
              <option value="3">9</option>
              <option value="3">10</option>
            </select>

            <hr><hr>
            <br>
            <h1>Team B</h1>
            <select class="browser-default custom-select" id="teamB"></select>
            <select class="browser-default custom-select">
              <option selected>Score</option>
              <option selected>Score</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="1">4</option>
              <option value="2">5</option>
              <option value="3">6</option>
              <option value="2">7</option>
              <option value="3">8</option>
              <option value="3">9</option>
              <option value="3">10</option>
            </select>
            <input type="submit" name="Play" value="submit">
          </form> -->

          <table class="table table-striped table-dark">
            <thead>
              <tr>
                <th scope="col">Name</th>
                <th scope="col">Country</th>
                <th scope="col">Level</th>
                <th scope="col">Season</th>
              </tr>
            </thead>
            <tbody id="league">

            </tbody>
          </table>

          <!--<table class="table custom-table">
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
          </table> -->
            <!--<h1 class="m-0 text-dark">Dashboard</h1> -->
          </div><!-- /.col -->

          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <!-- Info boxes -->
        <div class="row">

          <!-- /.col -->
         <!-- <div class="col-12 col-sm-6 col-md-3">
            <div class="info-box mb-3">
              <span class="info-box-icon bg-danger elevation-1"><i class="fas fa-thumbs-up"></i></span>

              <div class="info-box-content">
                <span class="info-box-text">Likes</span>
                <span class="info-box-number">41,410</span>
              </div>
             /.info-box-content -->
            </div>
            <!-- /.info-box -->
          </div>
          <!-- /.col -->

          <!-- fix for small devices only -->
          <div class="clearfix hidden-md-up"></div>

          <div class="col-12 col-sm-6 col-md-3">
            <!-- /.info-box -->
          </div>
          <!-- /.col -->
         <!-- <div class="col-12 col-sm-6 col-md-3">
            <div class="info-box mb-3">
              <span class="info-box-icon bg-warning elevation-1"><i class="fas fa-users"></i></span>

              <div class="info-box-content">
                <span class="info-box-text">New Leagues</span>
                <span class="info-box-number">2,000</span>
              </div>
               /.info-box-content -->
            </div>
            <!-- /.info-box -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->


        <!-- /.row -->
      </div><!--/. container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->

  <!-- Main Footer -->
  <%@ include file = "includes/footer.jsp"%>

</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->
<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- overlayScrollbars -->
<script src="plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.js"></script>

<!-- PAGE PLUGINS -->
<!-- jQuery Mapael -->
<script src="plugins/jquery-mousewheel/jquery.mousewheel.js"></script>
<script src="plugins/raphael/raphael.min.js"></script>
<script src="plugins/jquery-mapael/jquery.mapael.min.js"></script>
<script src="plugins/jquery-mapael/maps/usa_states.min.js"></script>
<!-- ChartJS -->
<script src="plugins/chart.js/Chart.min.js"></script>

<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="dist/js/pages/dashboard2.js"></script>
<script src="js/admin.js"></script>
<script>
  function teamsInLeague(id){
    window.location.href = 'teamsInALeague.jsp?id='+ id;
  }
  $.getJSON('../rest/league/show', function(data){
    var content = '';
    for(var i = 0; i<data.length; i++){
      var league = data[i];
      content+=`<tr>
                  <td><strong class="text-white"><a href='leagues.jsp?id=${league.id}'>${league.leagueName}</strong></td>
                  <td>${league.country}</td>
                  <td>${league.level}</td>
                  <td>${league.leagueId}</td>
                </tr>`;
    }
    $('#league').html(content);
  });
</script>
</body>
</html>
