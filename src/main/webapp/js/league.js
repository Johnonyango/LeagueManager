(function(){
   teams.showGrid.call({
   dataUrl: 'Teams?action=show',
   gridStyle: 'teamRender',
   componentId: 'organization',
   gridColumns:[{
            header: 'Name',
            dataIndex: 'Name'
        },{
            header: 'Code',
            dataIndex: 'teamCode'
        },{
             header: 'Games Played',
             dataIndex: 'numberOfGames'
        },{
             header: 'Points',
             dataIndex: 'Points'
        }],
        gridButtons: [{
            label: 'Add Team',
            cssClass: 'addButton',
            handler: 'addButton',
            id: 'team-addButton',
        },{
            label: 'Edit Team',
            cssClass: 'editButton',
            handler: 'editButton',
            id: 'team-editButton',
        },{
            label: 'Delete Team',
            cssClass: 'deleteButton',
            handler: 'deleteButton',
            id: 'team-deleteButton',
        }],
        formField: [{
            label: 'Team Name',
            name: 'Name',
            type: 'text',
            id: 'team-name'
        },{
            label: 'Team Code',
            name: 'code',
            type: 'text',
            id: 'teamCode'
        },{
             label: 'Games',
             name: 'games-played',
             type: 'number',
             id: 'games'
             },{
             label: 'Points',
             name: 'points',
             type: 'number',
             id: 'points'
             }]
   });
})();

function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}