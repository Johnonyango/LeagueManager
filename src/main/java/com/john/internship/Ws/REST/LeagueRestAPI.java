package com.john.internship.Ws.REST;

import com.john.internship.connection.db.bean.LeagueBeanI;
import com.john.internship.model.League;

import javax.ejb.EJB;
import javax.jws.WebParam;
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
    public Response show(@PathParam(value = "id") String name) throws Exception {
        return Response.status(200).entity(leagueBean.show()).build();
    }

    @GET
    @Path("/show/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam(value = "id") int id ) throws Exception { ;
        return Response.status(200).entity(leagueBean.show()).build();
    }

    @GET
    @Path(value = "/findByName/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public League getLeagueByName(@PathParam(value = "name") String name) {
        return leagueBean.getByName(name);
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

    @PUT
    @Path("/edit/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@WebParam int leagueId) throws Exception {
        leagueBean.load(leagueId);
    }


    @DELETE
    @Path("/delete/{id}")
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
