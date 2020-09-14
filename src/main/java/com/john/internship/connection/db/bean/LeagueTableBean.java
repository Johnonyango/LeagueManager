package com.john.internship.connection.db.bean;

import com.john.internship.model.League;
import com.john.internship.model.LeagueTable;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.util.List;

@Stateless
@Remote
public class LeagueTableBean implements LeagueTableBeanI {

    @PersistenceContext
    private EntityManager em;


    @Override
    public String add(LeagueTable table) throws Exception {
        if (table==null || table.getName()==null)
            throw new Exception("No valid table name provided");
        em.merge(table);
        return "Success";
    }

    @Override
    public List<LeagueTable> show(){
        return em.createQuery("From LeagueTable leagueTable").getResultList();
    }

    @Override
    public League load(int tableId) throws Exception{
        return em.find(League.class, tableId);
    }

    @Override
    public String search(Connection connection) {
        return null;
    }

    @Override
    public String update(Connection connection, LeagueTable team) {
        return null;
    }

    @Override
    public String remove(Connection connection) {
        return null;
    }
}
