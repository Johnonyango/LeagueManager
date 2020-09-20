package com.john.internship.Ws.REST;

import com.john.internship.connection.db.bean.LeagueTableBeanI;
import com.john.internship.model.LeagueTable;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/table")
public class LeagueTableRestAPI {

    @EJB
    private LeagueTableBeanI leagueTableBean;

    @GET
    @Path("/show")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam(value = "name") String name){

        System.out.println("Path param name: " + name);
        return Response.status(200).entity(leagueTableBean.show()).build();
    }


    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String save(LeagueTable table){
        try {
            leagueTableBean.add(table);
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
            leagueTableBean.remove(id);
        }catch (Exception ex){
            return "{\"FAILURE\":\"" + ex.getMessage() + "\"}";
        }

        return "{\"SUCCESS\":\"OK\"}";
    }
}
