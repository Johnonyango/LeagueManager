var leagueManager = leagueManager || {};

leagueManager.dbQuery = function(){
    var me = this;
    var formData = this.formData;
    

    var xhr = new XMLHttpRequest();

            var requestResponse = [];
            xhr.onreadystatechange = function(){
                if (xhr.readyState == XMLHttpRequest.DONE){
                    if (xhr.status == 200){
                        // requestResponse = eval('(' + xhr.responseText + ')');
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