(function(){
   leagueManager.showGrid.call({
   dataUrl: 'League',
   gridStyle: 'leagueRender',
   componentId: 'league',
   gridColumns:[{
            header: 'Name',
            dataIndex: 'name'
        },{
            header: 'Country',
            dataIndex: 'country'
        },{
             header: 'Level',
             dataIndex: 'level'
        }],
        gridButtons: [{
            label: 'Add League',
            cssClass: 'addButton',
            handler: 'addButton',
            id: 'league-addButton',
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
            label: 'League Name',
            name: 'Name',
            type: 'text',
            id: 'league-name'
        },{
            label: 'country',
            name: 'country',
            type: 'text',
            id: 'country'
        },{
             label: 'Level',
             name: 'level',
             type: 'number',
             id: 'level'
             }]
   });
})();
