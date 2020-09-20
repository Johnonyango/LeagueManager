package com.john.internship.Ws.soap;



import com.john.internship.connection.db.bean.TeamsBeanI;
import com.john.internship.model.Teams;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class TeamSoapApi {

    @EJB
    private TeamsBeanI teamsBean;

    @WebMethod(operationName = "show")
    public List<Teams> show() throws Exception {
        return teamsBean.show();
    }
    @WebMethod(operationName = "save")
    public String save(@WebParam Teams team) throws Exception {
        return teamsBean.add(team);
    }
    @WebMethod(operationName = "update")
    public Teams update(@WebParam int seasonId) throws Exception {
        return teamsBean.load(seasonId);
    }
    @WebMethod(operationName = "delete")
    public String delete(@WebParam int seasonId) throws Exception {
        return teamsBean.remove(seasonId);
    }

}
