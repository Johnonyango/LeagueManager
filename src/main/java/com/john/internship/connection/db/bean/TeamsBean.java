package com.john.internship.connection.db.bean;


import com.john.internship.model.League;
import com.john.internship.model.LeagueTable;
import com.john.internship.model.Teams;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Remote
public class TeamsBean implements TeamsBeanI {

    @PersistenceContext
    private EntityManager em;

    @EJB
    LeagueTableBeanI tableBean;


    @Override
    public String add(Teams team)throws Exception {
        if (team == null || team.getName() == null)
            throw new Exception("No valid table name provided");
        em.merge(team);
        LeagueTable table = new LeagueTable();
        table.setName(team.getName());
        table.setLeagueId(team.getLeagueId());
        table.setTeamCode(team.getCode());
        table.setNumberOfGames(0);
        table.setPoints(0);
        tableBean.add(table);
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
    public Teams searchByName(String name) {
        try {
            Query query = em.createNamedQuery("Teams.findByName", Teams.class);
            query.setParameter("name", name);
            return (Teams) query.getSingleResult();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
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

    @Override
    public int teamPoints(int points) throws Exception {
        return 0;
    }

    @Override
    public List<Teams> getByLeagueId(int leagueId) {
        try {
            Query query = em.createNamedQuery("Teams.getTeamsByLeagueId", Teams.class);
            query.setParameter("leagueId", leagueId);
            return query.getResultList();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }


}

