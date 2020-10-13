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
     console.log(JSON.stringify(formData));
     console.log(formData)
            xhr.open('post', me.dataUrl, false);
            xhr.setRequestHeader("Content-type", "application/json");
            xhr.send(JSON.stringify(formData));
}
/* additional code*/ 
function addLeague(){
    var leagueName, country, level;
    leagueName =document.getElementById('league-name').value;
    country =document.getElementById('country').value;
    level =document.getElementById('level').value;

    var params ='name='+name+'&country='+country+'&level='+level;

    var formToJson = {
        leagueName : leagueName,
        country : country,
        level : level
    };

    leagueManager.dbQuery.call({
        'formData':formToJson,
        'dataUrl':'../rest/league/save',
        callback:function(data){
            alert(data);
        }
    });
    
    }


function addTable(){
    var name, code, games, points;
    name =document.getElementById('team-name').value;
    teamCode =document.getElementById('code').value;
    numberOfGames =document.getElementById('games').value;
    points =document.getElementById('points').value;

    var params ='name='+name+'&code='+code+'&games='+games+'&points='+points;

        var formToJson = {
            name : name,
            teamCode : teamCode,
            numberOfGames : numberOfGames,
            points: points
        };

    leagueManager.dbQuery.call({
        'formData':formToJson,
        'dataUrl':'../rest/table/save',
        callback:function(data){
            alert(data);
        }
    });
}

function updateTable(){
    

        var formToJson = {
            teamA : teamA,
            teamB : teamB,
            points: points
        };

    leagueManager.dbQuery.call({
        'formData':formToJson,
        'dataUrl':'../rest/table/update/?/?/?/?',
        callback:function(data){
            alert(data);
        }
    });
}

function addTeam(){
    var code, name, leagueName, leagueId;
    code =document.getElementById('code').value;
    name =document.getElementById('name').value;
    leagueName =document.getElementById('league_name').value;
    leagueId =document.getElementById('league_id').value;

    var params ='code='+code+'&name='+name+'&leagueName='+leagueName+'&leaueId='+leagueId;
    console.log(params);

        var formToJson = {
            code : code,
            name : name,
            leagueName : leagueName,
            leagueId : leagueId
        };

    leagueManager.dbQuery.call({
            'formData':formToJson,
            'dataUrl':'../rest/teams/save',
            callback:function(data){
                alert(data);
            }
        });
}

function addSeason(){
    var fromYear, toYear, status;
    fromYear =document.getElementById('from_date').value;
    toYear =document.getElementById('to_date').value;
    status =document.getElementById('status').value;

    var params ='from_date='+from_date+'&to_date='+to_date+'&status='+status;

    var formToJson = {
        fromYear : fromYear,
        toYear : toYear,
        status : status
    };

    leagueManager.dbQuery.call({
        'formData':formToJson,
        'dataUrl':'../rest/seasons/save',
        callback:function(data){
            alert(data);
        }
    });
}

function login(){
    var username, password;
    username =document.getElementById('username').value;
    password =document.getElementById('password').value;

    if(username=='' || password==''){
        return;
    }

    $.post('./Auth', {
        'username':username,
        'password':password
    }, function(data){
        if(data.trim()=='Ok'){
            window.location.href = 'admin/index.jsp'
        }else{
            alert('invalid login credentials')
        }
    });
}

function fetchTeams(){
    $.getJSON('../rest/table/show', function(data){
        var teams = data;
    if (teams != null) {
    var teamA, teamB, content;
    teamA =document.getElementById('teamA');
    teamB =document.getElementById('teamB');
    content='';

        teams.forEach(team => {
            content += `<option value="${team.name}">${team.name}</option>`;
            
        });
        console.log(content)
        teamA.innerHTML = content;
        teamB.innerHTML = content;
    }
console.log(data)
    });
}