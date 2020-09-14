<%@ page import = "java.util.*"%>
<%@ page import = "com.john.internship.model.LeagueTable"%>
<%@ page import = "com.john.internship.connection.db.bean.LeagueBean"%>
<%@ page import = "com.john.internship.connection.db.bean.LeagueTableBean"%>
<%@ page import = "java.sql.Connection"%>
<!DOCTYPE html>
<html lang="en">
  <%@ include file = "header.jsp"%>

<body>
  <!-- sudo lsof -t -i tcp:80 -s tcp:listen | sudo xargs kill -->

  <div class="site-wrap">

    <div class="site-mobile-menu site-navbar-target">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>


  <%@ include file = "header.html"%>


    <div class="hero overlay" style="background-image: url('images/bg_3.jpg');">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-lg-5 ml-auto">
            <h1 class="text-white">Soccer Mama Yao</h1>
            <p>We nurture talents. We nurture soccer. Checkout out for open seasons to sign up in a league</p>
            <div id="date-countdown"></div>
            <p>
              <a href="#" class="btn btn-primary py-3 px-4 mr-3">Book Ticket</a>
              <a href="#" class="more light">Learn More</a>
            </p>
          </div>
        </div>
      </div>
    </div>



    <div class="container">


      <div class="row">
        <div class="col-lg-12">

          <div class="d-flex team-vs">
            <span class="score">4-1</span>
            <div class="team-1 w-50">
              <div class="team-details w-100 text-center">
                <img src="images/logo_1.png" alt="Image" class="img-fluid">
                <h3>LA LEGA <span>(win)</span></h3>
                <ul class="list-unstyled">
                  <li>Anja Landry (7)</li>
                  <li>Eadie Salinas (12)</li>
                  <li>Ashton Allen (10)</li>
                  <li>Baxter Metcalfe (5)</li>
                </ul>
              </div>
            </div>
            <div class="team-2 w-50">
              <div class="team-details w-100 text-center">
                <img src="images/logo_2.png" alt="Image" class="img-fluid">
                <h3>JUVENDU <span>(loss)</span></h3>
                <ul class="list-unstyled">
                  <li>Macauly Green (3)</li>
                  <li>Arham Stark (8)</li>
                  <li>Stephan Murillo (9)</li>
                  <li>Ned Ritter (5)</li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>


    <div class="site-section bg-dark">
      <div class="container">
        <div class="row">
          <div class="col-lg-1">
          </div>

          <div class="col-lg-10">

            <div class="widget-next-match">
              <%
              Connection dbConnection = (Connection) getServletContext().getAttribute("dbConnection");
              List<LeagueTable> teams = new LeagueTableBean().show(dbConnection);

              %>
              <table class="table custom-table">
                <thead>
                  <tr>
                    <th>P</th>
                    <th>Name</th>
                    <th>PW</th>
                    <th>Points</th>
                  </tr>
                </thead>
                <tbody>
                  <%
                  if(teams != null){
                    int P = 1;
                    for(LeagueTable leagueTable:teams){
                  %>
                  <tr>
                    <td><%=P%></td>
                    <td><strong class="text-white"><%=leagueTable.getName()%></strong></td>
                    <td><%=leagueTable.getNumberOfGames()%></td>
                    <td><%=leagueTable.getPoints()%></td>
                  </tr>
                  <%
                  P++;
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
    </div>
    <!-- sudo lsof -t -i tcp:80 -s tcp:listen | sudo xargs kill -->



    <footer class="footer-section">
      <div class="container">
        <div class="row">
          <div class="col-lg-3">
            <div class="widget mb-3">
              <h3>News</h3>
              <ul class="list-unstyled links">
                <li><a href="#">All</a></li>
                <li><a href="#">Club News</a></li>
                <li><a href="#">Media Center</a></li>
                <li><a href="#">Video</a></li>
                <li><a href="#">RSS</a></li>
              </ul>
            </div>
          </div>
          <div class="col-lg-3">
            <div class="widget mb-3">
              <h3>Tickets</h3>
              <ul class="list-unstyled links">
                <li><a href="#">Online Ticket</a></li>
                <li><a href="#">Payment and Prices</a></li>
                <li><a href="#">Contact &amp; Booking</a></li>
                <li><a href="#">Tickets</a></li>
                <li><a href="#">Coupon</a></li>
              </ul>
            </div>
          </div>
          <div class="col-lg-3">
            <div class="widget mb-3">
              <h3>Matches</h3>
              <ul class="list-unstyled links">
                <li><a href="#">Standings</a></li>
                <li><a href="#">World Cup</a></li>
                <li><a href="#">La Lega</a></li>
                <li><a href="#">Hyper Cup</a></li>
                <li><a href="#">World League</a></li>
              </ul>
            </div>
          </div>

          <div class="col-lg-3">
            <div class="widget mb-3">
              <h3>Social</h3>
              <ul class="list-unstyled links">
                <li><a href="#">Twitter</a></li>
                <li><a href="#">Facebook</a></li>
                <li><a href="#">Instagram</a></li>
                <li><a href="#">Youtube</a></li>
              </ul>
            </div>
          </div>

        </div>

        <div class="row text-center">
          <div class="col-md-12">
            <div class=" pt-5">
              <p>
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                Copyright &copy;
                <script>
                  document.write(new Date().getFullYear());
                </script> All rights reserved | This template is made with <i class="icon-heart"
                  aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
              </p>
            </div>
          </div>

        </div>
      </div>
    </footer>



  </div>
  <!-- .site-wrap -->

  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/jquery.countdown.min.js"></script>
  <script src="js/bootstrap-datepicker.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.fancybox.min.js"></script>
  <script src="js/jquery.sticky.js"></script>
  <script src="js/jquery.mb.YTPlayer.min.js"></script>


  <script src="js/main.js"></script>

</body>

</html>