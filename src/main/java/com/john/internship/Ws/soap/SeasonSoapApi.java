package com.john.internship.Ws.soap;


import com.john.internship.connection.db.bean.SeasonsBeanI;
import com.john.internship.model.Seasons;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class SeasonSoapApi {

    @EJB
    private SeasonsBeanI seasonsBean;

    @WebMethod(operationName = "show")
    public List<Seasons> show() throws Exception {
        return seasonsBean.show();
    }
    @WebMethod(operationName = "save")
    public String save(@WebParam Seasons season) throws Exception {
        return seasonsBean.start(season);
    }
    @WebMethod(operationName = "update")
    public Seasons update(@WebParam int seasonId) throws Exception {
        return seasonsBean.load(seasonId);
    }
    @WebMethod(operationName = "delete")
    public String delete(@WebParam int leagueId) throws Exception {
        return seasonsBean.drop(leagueId);
    }

}