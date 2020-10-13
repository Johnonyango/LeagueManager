package com.john.internship.Ws.REST;


import com.john.internship.connection.db.bean.TeamsBeanI;
import com.john.internship.model.League;
import com.john.internship.model.Teams;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/teams")
public class TeamsRestAPI {

    @EJB
    private TeamsBeanI teamsBean;

    @GET
    @Path("/show")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show() throws Exception {

        return Response.status(200).entity(teamsBean.show()).build();
    }

    @GET
    @Path("/show/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam(value = "id") int id ) throws Exception { ;
        return Response.status(200).entity(teamsBean.show()).build();
    }

    @GET
    @Path(value = "/findByName/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Teams getTeamByName(@PathParam(value = "name") String name) throws Exception {
        return teamsBean.searchByName(name);
    }


    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String save(Teams team){
        try {
            teamsBean.add(team);
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
            teamsBean.remove(id);
        }catch (Exception ex){
            return "{\"FAILURE\":\"" + ex.getMessage() + "\"}";
        }

        return "{\"SUCCESS\":\"OK\"}";
    }
}