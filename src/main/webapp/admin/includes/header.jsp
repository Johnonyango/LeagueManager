<%@page import="java.util.Enumeration"%>
<%@page import="com.john.internship.model.Users"%>


  <%!Users user = null;%>

<%
    Enumeration<String> vals = session.getAttributeNames();
    while (vals.hasMoreElements()) {
        String nextElement = vals.nextElement();
        if (nextElement.equalsIgnoreCase("user")) {
            user = (Users) session.getAttribute("user");
        }
    }
    if (user == null) {
        response.sendRedirect("../login.jsp");
        return;
    }
%>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bryte League</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">
  <link rel="stylesheet" href="includes/form.css">

</head>