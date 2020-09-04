<%@ page import = "java.util.*, com.john.internship.connection.db.*"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file = "page/header.html"%>
<body bgcolor="cyan">
<%@ include file = "page/navbar.jsp"%>

<%--
<%
List<UserTest>users;

if(session.getAttribute("users")==null)
  users = new ArrayList<UserTest>();
users = (List<UserTest>) session.getAttribute("users");

String name = request.getParameter("name");
String email = request.getParameter("email");
String address = request.getParameter("address");
String password = request.getParameter("password");

if(name != null ||  email!=null || address!=null || password!=null){
UserTest user = new UserTest();

user.setName(name);
user.setEmail(email);
user.setAddress(address);
user.setPassword(password);

users.add(user);

}


List<String>someNames = new ArrayList<>();
someNames.add("John");
someNames.add("James");
someNames.add("Anyango");



for(UserTest user:users)
out.println(ShowUserTest.showUser(user));

session.setAttribute("users", users);



%>  --%>
  <!--
<form action="#" method="POST">
      Name: <input type="text" name="name">
      Address: <input type="text" name="address">
      Email: <input type="text" name="email">
      Password: <input type="password" name="password">
      <input class="btn btn-success" type="submit" value="Submit">
    </form>
-->
   <div class="container">
    <h1>Oduma League</h1>
    <table class="table table-dark">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Team</th>
          <th scope="col">P</th>
          <th scope="col">Points</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">1</th>
          <td>Sunderland</td>
          <td>5</td>
          <td>13</td>
        </tr>
        <tr>
          <th scope="row">2</th>
          <td>Bandari FC</td>
          <td>5</td>
          <td>11</td>
        </tr>
        <tr>
          <th scope="row">3</th>
          <td>Leeds United</td>
          <td>5</td>
          <td>11</td>
        </tr>
      </tbody>
    </table>
    </div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</body>
</html>