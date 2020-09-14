package com.john.internship.connection.db.bean;


import com.john.internship.model.League;
import com.john.internship.model.Teams;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Remote
public class TeamsBean implements TeamsBeanI {

    @PersistenceContext
    private EntityManager em;


    @Override
    public String add(Teams team)throws Exception {
        if (team == null || team.getName() == null)
            throw new Exception("No valid table name provided");
        em.merge(team);
        return "Success";
    }

    @Override
    public List<Teams> show() {
        return em.createQuery("From Teams teams").getResultList();
    }

    @Override
    public League search(int teamId) throws Exception {
//        if (leagueId == 0)
//        return leagueId
        return null;
    }

    @Override
    public String remove(int teamId) throws Exception{
        if (teamId == 0)
            throw new Exception("Invalid faculty details!!");

        System.out.println("team id>>>>> " + teamId);
        em.remove(em.find(Teams.class, teamId));

        return "OK";
    }
}

