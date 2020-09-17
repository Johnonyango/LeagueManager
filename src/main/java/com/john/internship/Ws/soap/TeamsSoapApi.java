package com.john.internship.Ws.soap;

import com.john.internship.connection.db.bean.LeagueBeanI;
import com.john.internship.connection.db.bean.TeamsBeanI;
import com.john.internship.model.League;
import com.john.internship.model.Teams;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class TeamsSoapApi {

    @EJB
    LeagueBeanI leagueBean;

    @WebMethod
    public List<League> teams(@WebParam String name) throws Exception {
        return leagueBean.show();
    }
}