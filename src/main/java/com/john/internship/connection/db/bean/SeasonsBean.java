package com.john.internship.connection.db.bean;

import com.john.internship.model.League;
import com.john.internship.model.Seasons;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        if (seasons==null || seasons.getFromYear()==null || seasons.getToYear()==null)
            throw new Exception("No valid table name provided");
        em.merge(seasons);
        return "Success";
    }

    @Override
    public List<Seasons> show() {
        return em.createQuery("FROM Seasons season").getResultList();
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
