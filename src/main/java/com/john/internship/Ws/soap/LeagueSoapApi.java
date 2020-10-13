package com.john.internship.Ws.soap;

import com.john.internship.connection.db.bean.LeagueBeanI;
import com.john.internship.model.League;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class LeagueSoapApi {

    @EJB
    private LeagueBeanI leagueBean;

    @WebMethod(operationName = "show")
    public List<League> show(@WebParam League league) throws Exception {
        return leagueBean.show();
    }

    @WebMethod(operationName = "getByName")
    public League getRoomByName(@WebParam(name = "name") String name) {
        return leagueBean.getByName(name);
    }

    @WebMethod(operationName = "save")
    public String save(@WebParam League league) throws Exception {
        return leagueBean.create(league);
    }
    @WebMethod(operationName = "update")
    public void update(@WebParam int leagueId) throws Exception {
        leagueBean.load(leagueId);
    }


    @WebMethod(operationName = "delete")
    public String delete(@WebParam int leagueId) throws Exception {
        return leagueBean.remove(leagueId);
    }

}