package com.john.internship.Ws.REST;

import com.john.internship.connection.db.bean.CoachBeanI;
import com.john.internship.connection.db.bean.TeamsBeanI;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/coach")
public class CoachRestApi {

    @EJB
    private CoachBeanI coachBean;

    @GET
    @Path("/show")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show() throws Exception {

        return Response.status(200).entity(coachBean.show()).build();
    }
}
