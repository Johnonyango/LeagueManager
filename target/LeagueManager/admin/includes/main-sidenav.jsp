<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo --
    <a href="index3.html" class="brand-link">
      <img src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">Bryte League</span>
    </a> -->

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
              <a href="#" class="d-block"><%=user.getUsername().toUpperCase()%></a> 
              <a href="../Auth" class="d-block">LOGOUT</a>
        </div>
      </div>

      <!-- SidebarSearch Form 
      <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
          <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
          <div class="input-group-append">
            <button class="btn btn-sidebar">
              <i class="fas fa-search fa-fw"></i>
            </button>
          </div>
        </div>
      </div> -->

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item menu-open">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                Dashboard
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="./allLeagues.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Home Dashboard</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="./league.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Leagues</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="./allLeagues.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>View Leagues</p>
                </a>
              </li>
             
              <li class="nav-item">
                <a href="./teams.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Teams</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="./table.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Create LeagueTable</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="./seasons.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Create Seasons</p>
                </a>
              </li>
            </ul>
          </li>
          <!-- <li class="nav-item">
            <a href="pages/widgets.html" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Widgets
                <span class="right badge badge-danger">New</span>
              </p>
            </a>
          </li> -->
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-copy"></i>
              <p>
                Client Side Menu
                <i class="fas fa-angle-left right"></i>
                <!-- <span class="badge badge-info right">6</span> -->
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="../index.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Home</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="../league.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Leagues</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="../teams.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Teams</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="../seasons.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Seasons</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-chart-pie"></i>
              <p>
                Statistics
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>