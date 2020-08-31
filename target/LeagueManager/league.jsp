<!DOCTYPE html>
<html>
<head>
<%@ include file = "page/header.jsp"%>
<script src="js/app.js"></script>

    <style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>
<% out.println(session.getAttribute("username")); %>
<%@ include file = "page/navbar.jsp"%>
<div id="content">

</div>
<script src="js/league.js"></script>

</body>
</html>