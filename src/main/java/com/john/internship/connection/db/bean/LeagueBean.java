package com.john.internship.connection.db.bean;
import com.john.internship.model.League;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Remote
public class LeagueBean implements LeagueBeanI {

    @PersistenceContext
    private EntityManager em;

    public String create(League league) throws Exception {
        if (league == null || league.getName() == null)
            throw new Exception("No valid table name provided");
        em.merge(league);
        return "Success";
    }

    @Override
    public List<League> show() throws Exception {
        return em.createQuery("FROM League league").getResultList();
    }

    @Override
    public League load(int leagueId) throws Exception {
        return em.find(League.class, leagueId);
    }

    @Override
    public League search(int leagueId) throws Exception {
//        if (leagueId == 0)
//        return leagueId
        return null;
    }

    @Override
    public String remove(int leagueId) throws Exception {
        try {
            if (leagueId == 0)
                return "invalid Id";

            League league = em.find(League.class, leagueId);
            if (league != null){
                em.remove(em.merge(league));
            }
            return "successfully deleted";
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return "Opertation failed";
    }
}