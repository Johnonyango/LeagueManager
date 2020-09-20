package com.john.internship.Ws.soap;

import com.john.internship.connection.db.bean.LeagueTableBeanI;
import com.john.internship.model.League;
import com.john.internship.model.LeagueTable;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class LeagueTableSoapApi {

    @EJB
    private LeagueTableBeanI leagueTableBean;

    @WebMethod(operationName = "show")
    public List<LeagueTable> show() throws Exception {
        return leagueTableBean.show();
    }
    @WebMethod(operationName = "save")
    public String save(@WebParam LeagueTable table) throws Exception {
        return leagueTableBean.add(table);
    }
    @WebMethod(operationName = "update")
    public League update(@WebParam int tableId) throws Exception {
        return leagueTableBean.load(tableId);
    }
    @WebMethod(operationName = "delete")
    public String delete(@WebParam int tableId) throws Exception {
        return leagueTableBean.remove(tableId);
    }

}
