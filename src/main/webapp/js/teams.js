(function(){
   leagueManager.showGrid.call({
   dataUrl: 'Team',
   gridStyle: 'customers',
   componentId: 'organization',
   gridColumns:[{
            header: 'Name',
            dataIndex: 'name'
        },{
            header: 'Code',
            dataIndex: 'teamCode'
        },{
             header: 'Games Played',
             dataIndex: 'numberOfGames'
        },{
              header: 'Games Played',
              dataIndex: 'numberOfGames'
           },{
              header: 'Action',
              dataIndex: '-1',
              actionButtons:[
              {text:'delete', dataIndex:'name',
              action:function (id){alert(id)}},
              {text:'update', dataIndex:'name', action:function (id){}}]
        }],
        gridButtons: [{
            label: 'Add Team',
            cssClass: 'addButton',
            handler: 'addButton',
            id: 'team-addButton',
        },{
            label: 'Update League',
            cssClass: 'editButton',
            handler: 'editButton',
            id: 'league-editButton',
        },{
            label: 'Delete League',
            cssClass: 'deleteButton',
            handler: 'deleteButton',
            id: 'league-deleteButton',
        }],
        formField: [{
            label: 'Team Name',
            name: 'name',
            type: 'text',
            id: 'team-name'
        },{
            label: 'Team Code',
            name: 'code',
            type: 'text',
            id: 'code'
        },{
             label: 'Games Played',
             name: 'games',
             type: 'number',
             id: 'games'
        },{
              label: 'Points',
              name: 'points',
              type: 'number',
              id: 'points'
        }],
             gridButtons: [{
              label: 'Add Team',
              cssClass: 'addButton',
              handler: 'addButton',
              id: 'team-addButton',
        }]
   });
})();
