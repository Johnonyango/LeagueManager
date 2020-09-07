(function(){
   leagueManager.showGrid.call({
   dataUrl: 'Seasons',
   gridStyle: 'customers',
   componentId: 'organization',
   gridColumns:[{
            header: 'Start Date',
            dataIndex: 'from_date'
        },{
            header: 'End Date',
            dataIndex: 'to_date'
        },{
             header: 'Status',
             dataIndex: 'status'
        },{
              header: 'Action',
              dataIndex: '-1',
              actionButtons:[
              {text:'drop', dataIndex:'name',
              action:function (id){alert(id)}},
              {text:'update', dataIndex:'name', action:function (id){}}]
        }],
        gridButtons: [{
            label: 'Start Season',
            cssClass: 'addButton',
            handler: 'addButton',
            id: 'team-addButton',
        }],
        formField: [{
            label: 'Start Date',
            name: 'from_date',
            type: 'date',
            id: 'start_date'
        },{
            label: 'End Date',
            name: '',
            type: 'date',
            id: 'to_date'
        },{
             label: 'Status',
             name: 'status',
             type: 'text',
             id: 'status'
        }],
             gridButtons: [{
              label: 'Start a Season',
              cssClass: 'addButton',
              handler: 'addButton',
              id: 'team-addButton',
        }]
   });
})();
