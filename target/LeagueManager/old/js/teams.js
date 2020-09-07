(function(){
   leagueManager.showGrid.call({
   dataUrl: 'Teams',
   gridStyle: 'customers',
   componentId: 'organization',
   gridColumns:[{
            header: 'Name',
            dataIndex: 'name'
        },{
            header: 'Code',
            dataIndex: 'code'
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
            label: 'Update Team',
            cssClass: 'editButton',
            handler: 'editButton',
            id: 'team-editButton',
        },{
            label: 'Delete League',
            cssClass: 'deleteButton',
            handler: 'deleteButton',
            id: 'team-deleteButton',
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
        }],
             gridButtons: [{
              label: 'Add Team',
              cssClass: 'addButton',
              handler: 'addButton',
              id: 'team-addButton',
        }]
   });
})();
