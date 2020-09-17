var leagueManager = leagueManager || {};

leagueManager.dbQuery = function(){
    var me = this;
    var formData = this.formData;
    

    var xhr = new XMLHttpRequest();

            var requestResponse = [];
            xhr.onreadystatechange = function(){
                if (xhr.readyState == XMLHttpRequest.DONE){
                    if (xhr.status == 200){
                        //requestResponse = eval('(' + xhr.responseText + ')');
                        me.callback(xhr.responseText);

                    }
                }
            }
     console.log(formData);
            xhr.open('post', me.dataUrl, false);
            xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhr.send(formData);
}
/* additional code*/ 
function addLeague(){
    var name, country, level;
    name =document.getElementById('league-name').value;
    country =document.getElementById('country').value;
    level =document.getElementById('level').value;

    var params ='name='+name+'&country='+country+'&level='+level;
    console.log(params);

    leagueManager.dbQuery.call({
        'formData':params,
        'dataUrl':'../League',
        callback:function(data){
            alert(data);
        }
    });
}

function addTable(){
    var name, code, games, points;
    name =document.getElementById('team-name').value;
    code =document.getElementById('code').value;
    games =document.getElementById('games').value;
    points =document.getElementById('points').value;

    var params ='name='+name+'&code='+code+'&games='+games+'&points='+points;
    console.log(params);

    leagueManager.dbQuery.call({
        'formData':params,
        'dataUrl':'../Table',
        callback:function(data){
            alert(data);
        }
    });
}

function addTeam(){
    var code, name, league_name;
    code =document.getElementById('code').value;
    name =document.getElementById('name').value;
    league_name =document.getElementById('league_name').value;

    var params ='code='+code+'&name='+name+'&league_name='+league_name;
    console.log(params);

    leagueManager.dbQuery.call({
        'formData':params,
        'dataUrl':'../Teams',
        callback:function(data){
            alert(data);
        }
    });
}

function addSeason(){
    var from_date, to_date, level;
    from_date =document.getElementById('from_date').value;
    to_date =document.getElementById('to_date').value;
    status =document.getElementById('status').value;

    var params ='from_date='+from_date+'&to_date='+to_date+'&status='+status;
    console.log(params);

    leagueManager.dbQuery.call({
        'formData':params,
        'dataUrl':'../Seasons',
        callback:function(data){
            alert(data);
        }
    });
}