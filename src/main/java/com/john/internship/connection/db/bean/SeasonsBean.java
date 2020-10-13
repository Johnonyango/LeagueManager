package com.john.internship.connection.db.bean;

import com.john.internship.model.League;
import com.john.internship.model.Seasons;
import com.john.internship.model.Teams;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote
public class SeasonsBean implements SeasonsBeanI{

    @PersistenceContext
    private EntityManager em;

    @Override
    public String start(Seasons seasons)  throws Exception {
        if (seasons==null)
           throw new Exception("No valid season provided");
        em.merge(seasons);
        return "Success";
    }

    @Override
    public List<Seasons> show() {
        return em.createQuery("FROM Seasons season").getResultList();
    }

@Override
    public Seasons search(int id) throws Exception{
        try {
            Query query = em.createNamedQuery("Seasons.findById", Seasons.class);
            query.setParameter("id", id);
            return (Seasons) query.getSingleResult();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }


    @Override
    public Seasons load(int seasonId) throws Exception{
        return em.find(Seasons.class, seasonId);
    }

    @Override


    public String drop(int seasonId) throws Exception {
        try {
            if (seasonId == 0)
                return "invalid Id";

            Seasons season = em.find(Seasons.class, seasonId);
            if (season != null){
                em.remove(em.merge(season));
            }
            return "successfully deleted";
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return "Operation failed";
    }
}
