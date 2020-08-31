<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>League Table</title>
</head>
<body>

<%
String first_name = "John";
String last_name = "Onyango";
int age = 21;
String address = "Nairobi";

session.setAttribute("fname", first_name);
session.setAttribute("lname", last_name);
session.setAttribute("hisAge", age);
session.setAttribute("hisAddress", address);

%>
<a href="display.jsp">Display page</a>
<a href="error.jsp">Error page</a>

  <div class="container">
     <div id="table">
     </div>
  </div>

<script>
var teams = [{
Team: 'Chelsea',
Code: 'Chel01',
Games: 20,
Points: 43
},{
 Team: 'Sunderland',
 Code: 'Sun01',
 Games: 20,
 Points: 41
 },{
  Team: 'Arsenal',
  Code: 'Ass01',
  Games: 20,
  Points: 39
  }]

  var tableContent = '<table style="width:100%">'
                       + '<tr>'
                          +'<th>Team Name</th>'
                          +'<th>Team code</th>'
                          +'<th>Games Played</th>'
                          + '<th>Points</th>'
                        +'</tr>';
  for(var i=0; i<teams.length; i++){
  tableContent+= '<tr>'
                      + '<td>'+teams[i].Team +'</td>'
                       +'<td>'+teams[i].Code +'</td>'
                       +'<td>'+teams[i].Games +'</td>'
                       +'<td>'+teams[i].Points +'</td>'
                           +'</tr>';
  }
  tableContent+='</table>';

document.getElementById('table').innerHTML = tableContent;
</script>
</body>
</html>