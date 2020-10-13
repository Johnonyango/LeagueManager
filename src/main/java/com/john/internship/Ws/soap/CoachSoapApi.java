package com.john.internship.Ws.soap;



import com.john.internship.connection.db.bean.CoachBeanI;
import com.john.internship.model.Coach;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class CoachSoapApi {

    @EJB
    private CoachBeanI coachBean;

    @WebMethod(operationName = "show")
    public List<Coach> show() throws Exception {
        return coachBean.show();
    }


    @WebMethod(operationName = "save")
    public String save(@WebParam Coach coach) throws Exception {
        return coachBean.add(coach);
    }


    @WebMethod(operationName = "delete")
    public String delete(@WebParam int coachId) throws Exception {
        return coachBean.delete(coachId);
    }

}