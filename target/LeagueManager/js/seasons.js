(function(){
    leagueManager.showGrid.call({
        dataUrl: 'Seasons',
        gridStyle: 'customers',
        componentId: 'organization',
        gridColumns:[{
            header: 'From_Date',
            dataIndex: 'from_date'
        },{
            header: 'To_Date',
            dataIndex: 'to_date'
        },{
            header: 'Status',
            dataIndex: 'status'
        }],
        gridButtons: [{
            label: 'Start a Season',
            cssClass: 'addButton',
            handler: 'addButton',
            id: 'startSeason',
        },{
            label: 'End Season',
            cssClass: 'deleteButton',
            handler: 'deleteButton',
            id: 'endSeason',
        },{
            label: 'ViewAll Seasons',
            cssClass: 'viewButton',
            handler: 'viewButton',
            id: 'view_season',
        }],
        formField: [{
            label: 'From Date',
            name: 'from',
            type: 'number',
            id: 'from_date'
        },{
            label: 'To Date',
            name: 'to',
            type: 'number',
            id: 'to_date'
        },{
            label: 'Status',
            name: 'status',
            type: 'text',
            id: 'status'
        }]
    });
})();