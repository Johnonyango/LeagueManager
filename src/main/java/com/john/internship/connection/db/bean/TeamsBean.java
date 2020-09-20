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
        return em.createQuery("FROM Teams team").getResultList();
    }

    @Override
    public Teams load(int teamId) throws Exception {
        return em.find(Teams.class, teamId);
    }

    @Override
    public League search(int teamId) throws Exception {
//        if (leagueId == 0)
//        return leagueId
        return null;
    }

    @Override
    public String remove(int teamId) throws Exception {
        try {
            if (teamId == 0)
                return "invalid Id";

            Teams team = em.find(Teams.class, teamId);
            if (team != null){
                em.remove(em.merge(team));
            }
            return "successfully deleted";
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return "Opertation failed";
    }
}

