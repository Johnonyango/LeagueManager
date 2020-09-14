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
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">Dashboard v2</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Dashboard v2</li>
            </ol>
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
          <div class="col-12 col-sm-6 col-md-3">
            <!-- /.info-box -->
          </div>
          <!-- /.col -->
          <div class="col-12 col-sm-6 col-md-6">
            <div class="card card-primary">
                <div class="card-header">
                  <h3 class="card-title">Add Table</h3>
                </div>
                <!-- /.card-header -->
                <!-- form start -->
                <form onsubmit="return false">
                  <div class="card-body">
                    <div class="form-group">
                      <label for="exampleInputEmail1">Name</label>
                      <input type="text" class="form-control" id="team-name" placeholder="Team Name">
                    </div>
                    <div class="form-group">
                      <label for="exampleInputPassword1">Team Code</label>
                      <input type="text" class="form-control" id="code" placeholder="Team Code">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Number of Games</label>
                        <input type="number" class="form-control" id="games" placeholder="Games Played">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword1">Points</label>
                        <input type="number" class="form-control" id="points" placeholder="Points">
                      </div>
                  </div>
                  <!-- /.card-body -->
                  <div class="card-footer">
                    <button type="submit" class="btn btn-primary" onclick="addTable()">Submit</button>
                  </div>
                </form>
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
  
  </body>
  </html>
  