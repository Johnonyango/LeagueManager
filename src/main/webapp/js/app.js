var teams = teams || {};

teams.showTable = function(){
var tableContent = `<table style="width:100%"  id="table"><tr><th>Team Name</th><th>Team code</th><th>Games Played</th><th>Points</th>`;

 me.data.forEach(row =>{
       tableContent += `<tr></td>$(row.Name)<td></td>$(row.teamCode)<td></td>$(row.Games)<td></td>$(row.Points)</tr></td>`;
 })
 tableContent+=`</table>`;
  document.getElementById('content').innerHTML = tableContent;
 }
teams.loadData = function(){
var me = this;
  var xhr = XMLHttpRequest();
  xhr.onreadystatechange = function(){
    if(xhr.readyState = XMLHttpRequest.DONE){
      if(xhr.status = 200){
         teams.data = eval('(' + xhr.responseText + ')');
         teams.showTable();

      }
  }
}
xhr.open(me.dataUrl, true);
xhr.send();
}