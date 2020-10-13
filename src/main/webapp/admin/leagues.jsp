
<!DOCTYPE html>
<html lang="en">
<%@ include file = "includes/header.jsp"%>
<style>
  #overlay {
    position: fixed;
    display: none;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: rgba(0,0,0,0.5);
    z-index: 2;
    cursor: pointer;
  }
  
  #text{
    position: absolute;
    top: 50%;
    left: 50%;
    font-size: 50px;
    color: white;
    transform: translate(-50%,-50%);
    -ms-transform: translate(-50%,-50%);
  }
  </style>
<body class="hold-transition sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">

<div class="wrapper">

  <div id="overlay" onclick="">
    <div id="text">Playing...</div>
  </div>
  
  <!-- Navbar -->
  <%@ include file = "includes/navbar.jsp"%>

  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <%@ include file = "includes/main-sidenav.jsp"%>

<%
String id = request.getParameter("id");
%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
        <button onclick="simulate()" style="text-align: center;">Play a Match</button>

        

        <table class="table table-striped table-dark">
          <thead>
            <tr>
              <th scope="col">Scores</th>
            </tr>
          </thead>
          <tbody id="tbl">

          </tbody>
        </table>
       
        <!-- <table  class="table custom-table">
          <tr>
              <th>Scores</th>
          </tr>
          <tbody id="tbl">

          </tbody>
      </table>-->

            <!--<h1 class="m-0 text-dark">Dashboard</h1> -->
          </div><!-- /.col -->

          </div><!-- /.col -->
          <div class="row mb-12">
            <div class="col-sm-12">

              <table class="table table-striped table-dark">
                <thead>
                  <tr>
                    <th scope="col">N</th>
                    <th scope="col">Name</th>
                    <th scope="col">P</th>
                    <th scope="col">Points</th>
                  </tr>
                </thead>
                <tbody id="table">
    
                </tbody>
              </table>
    
           <!-- <table class="table custom-table">
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


<!-- Overlay-->


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

function on() {
  document.getElementById("overlay").style.display = "block";
}

function off() {
  document.getElementById("overlay").style.display = "none";
}

 function simulate() {
                   // $('#game').text("Playing......");
                   on();
                    setTimeout(function () {
                        $.getJSON('../rest/table/simulateGame/<%= id%>', function (data) {
                            var content = '';
                            data.forEach(game => {
                                content += `<tr>
                        <td>${game.team} <b>${game.teamS}</b> : <b>${game.opponentS}</b> ${game.opponent}</td>
                    </tr>`;
                            });

                            $('#tbl').html(content);
                            off();
                            load();
                        });
                    }, 5000);
                }

                function load(){

  $.getJSON('../rest/table/findTableByLeagueId/<%= id%>', function(data){
    var content = '';
    for(var i = 0; i<data.length; i++){
      var leagueTable = data[i];
      content+=`<tr>
                  <td>${i+1}</td>
                  <td><strong class="text-black">${leagueTable.name}</strong></td>
                  <td>${leagueTable.numberOfGames}</td>
                  <td>${leagueTable.points}</td>
                </tr>`;
    }
    $('#table').html(content);
  });
                }
                load();
  
  </script>
</body>
</html>
