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
          </div><!-- /.col -->
          <div class="col-sm-6">

          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->

    <section class="content">
      <h1 class="content__heading">Start a Season</h1>
      <!-- <p class="content__lede">Use this handy contact form to get in touch with me.</p> -->
      <form class="content__form contact-form" onsubmit="return false">
        <div class="contact-form__input-group">
          <label class="contact-form__label" for="code">From Date</label>
          <input class="contact-form__input contact-form__input--text" id="from_date" name="from_date" type="date"/>
        </div>
        <div class="contact-form__input-group">
          <label class="contact-form__label" for="name">To Date</label>
          <input class="contact-form__input contact-form__input--text" id="to_date" name="to_date" type="date"/>
        </div>
        <div class="contact-form__input-group">
          <label class="contact-form__label" for="email">Status</label>
          <input class="contact-form__input contact-form__input--number" id="status" name="status" type="text"/>
        </div>
        <div class="contact-form__input-group">

        </div>

        <input name="secret" type="hidden" value="1b3a9374-1a8e-434e-90ab-21aa7b9b80e7"/>
        <button class="contact-form__button" type="submit" onclick="addSeason()">Start a Season</button>
      </form>
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

<script src="dist/js/demo.js"></script>
<script src="dist/js/pages/dashboard2.js"></script>
<script src="js/admin.js"></script>

</body>
</html>
