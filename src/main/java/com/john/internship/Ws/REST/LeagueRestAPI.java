package com.john.internship.Ws.REST;

import com.john.internship.connection.db.bean.LeagueBeanI;
import com.john.internship.model.League;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/league")
public class LeagueRestAPI {

    @EJB
    private LeagueBeanI leagueBean;

    @GET
    @Path("/show")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam(value = "name") String name) throws Exception {

        System.out.println("Path param name: " + name);
        return Response.status(200).entity(leagueBean.show()).build();
    }


    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String save(League league){
        try {
            leagueBean.create(league);
        }catch (Exception ex){
            return "{\"FAILURE\":\"" + ex.getMessage() + "\"}";
        }

        return "{\"SUCCESS\":\"OK\"}";
    }
    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam(value = "id") int id){
        try {
            leagueBean.remove(id);
        }catch (Exception ex){
            return "{\"FAILURE\":\"" + ex.getMessage() + "\"}";
        }

        return "{\"SUCCESS\":\"OK\"}";
    }
}
