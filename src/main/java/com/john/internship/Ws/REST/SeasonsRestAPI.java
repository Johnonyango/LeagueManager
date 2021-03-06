package com.john.internship.Ws.REST;



import com.john.internship.connection.db.bean.SeasonsBeanI;
import com.john.internship.model.Seasons;
import com.john.internship.model.Teams;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/seasons")
public class SeasonsRestAPI {

    @EJB
    private SeasonsBeanI seasonsBean;

    @GET
    @Path("/show")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam(value = "name") String name) throws Exception {

        System.out.println("Path param name: " + name);
        return Response.status(200).entity(seasonsBean.show()).build();
    }

    @GET
    @Path(value = "/findById/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Seasons getTeamById(@PathParam(value = "name") int id) throws Exception {
        return seasonsBean.search(id);
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String save(Seasons season){
        try {
            seasonsBean.start(season);
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
            seasonsBean.drop(id);
        }catch (Exception ex){
            return "{\"FAILURE\":\"" + ex.getMessage() + "\"}";
        }

        return "{\"SUCCESS\":\"OK\"}";
    }
}
