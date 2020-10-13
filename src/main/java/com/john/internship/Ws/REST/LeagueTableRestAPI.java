package com.john.internship.Ws.REST;

import com.john.internship.connection.db.bean.LeagueTableBeanI;
import com.john.internship.model.Game;
import com.john.internship.model.LeagueTable;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @POST
    @Path("/update/{teamA}/{teamAPoints}/{teamB}/{teamBPoints}")
    //@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@PathParam(value = "teamA")String teamA, @PathParam(value = "teamAPoints")int teamAPoints,
                         @PathParam(value = "teamB")String teamB, @PathParam(value = "teamBPoints")int teamBPoints ){
        try {
            leagueTableBean.findWinner(teamA, teamB, teamAPoints,teamBPoints);
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

    @GET
    @Path("/simulateGame/{leagueId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Game> simulateGame(@PathParam(value = "leagueId")int leagueId){
        try {
            return leagueTableBean.simulateGame(leagueId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("/findTableByLeagueId/{leagueId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LeagueTable> findTableByLeagueId(@PathParam(value = "leagueId")int leagueId) {
        try {
            return leagueTableBean.findTableByLeagueId(leagueId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
