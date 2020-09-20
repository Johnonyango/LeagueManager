
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
            <!--<div id="date-countdown"></div>
            <p>
              <a href="#" class="btn btn-primary py-3 px-4 mr-3">Book Ticket</a>
              <a href="#" class="more light">Learn More</a>
            </p>-->
          </div>
        </div>
      </div>
    </div>



   <!-- <div class="container">


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
    </div> -->


    <div class="site-section bg-dark">
      <div class="container">
        <div class="row">
          <div class="col-lg-1">
          </div>

          <div class="col-lg-10">

            <div class="widget-next-match">
              <h1 style="text-align: center;">Top League</h1>
              <table class="table custom-table">
                <thead>
                  <tr>
                    <th>P</th>
                    <th>Name</th>
                    <th>PW</th>
                    <th>Points</th>
                    <th>Action</th>
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
                </script> All rights reserved. By <a href="index.jsp" target="_blank">Bryte League Sports</a>
              </p>
            </div>
          </div>

        </div>
      </div>
    </footer>



  </div>
  <!-- .site-wrap -->

   <%@ include file = "sitewrap.jsp"%>



  <script src="js/main.js"></script>
    <script>
    $.getJSON('Table', function(data){
      var content = '';
      for(var i = 0; i<data.length; i++){
        var leagueTable = data[i];
        content+=`<tr>
                    <td>${i+1}</td>
                    <td><strong class="text-white">${leagueTable.name}</strong></td>
                    <td>${leagueTable.numberOfGames}</td>
                    <td>${leagueTable.points}</td>
                    <td>${leagueTable.action}</td>
                  </tr>`;
      }
      $('#table').html(content);
    });
    
    </script>



</body>

</html>