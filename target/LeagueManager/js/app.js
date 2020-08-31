var teams = teams || {};

teams.showTable = function(){
var tableContent = `<table style="width:100%"  id="myTable"><tr><th>Team Name</th><th>Team code</th><th>Games Played</th><th>Points</th></tr>`;

 teams.data.forEach(row =>{
       tableContent += `<tr><td>${row.name}</td><td>${row.teamCode}</td><td>${row.numberOfGames}</td><td>${row.points}</td></tr>`;
 })
 tableContent+=`</table>`;
  document.getElementById('content').innerHTML = tableContent;
 }

teams.loadData = function(){
var me = this;
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function(){
    if(xhr.readyState = XMLHttpRequest.DONE){
      if(xhr.status = 200){
//      console.log(xhr.responseText);
         teams.data = eval('(' + xhr.responseText + ')');
         teams.showTable();
      }
  }
}
xhr.open('get', me.dataUrl, true);
xhr.send();
}