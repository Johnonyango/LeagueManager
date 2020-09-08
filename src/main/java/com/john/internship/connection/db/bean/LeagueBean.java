package com.john.internship.connection.db.bean;

import com.john.internship.connection.db.annotation.SaveToDb;
import com.john.internship.model.League;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote
public class LeagueBean implements LeagueBeanI{

    @PersistenceContext
    private EntityManager em;

    public String create(League league) {
        em.merge(league);
        return "OK";
    }

    @Override
    public List<League> show() {
        return em.createQuery("FROM League l").getResultList();
    }

    @Override
    public League search(Connection connection, String name) {

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM leagues where name=?");
            statement.setString(1, name);
            statement.execute();
            ResultSet result = statement.getResultSet();

            if (result.next()) {
                League league = new League();
                league.setName(result.getString("name"));
                league.setCountry(result.getString("country"));
                league.setLevel(result.getInt("level"));

                return  league;
            }

        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean remove(Connection connection, League league) {
        boolean leagueRemoved = false;
        String deleteQuery = "delete from leagues where name = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            statement.execute();
            statement.setString(1, "name");
            leagueRemoved =statement.executeUpdate()>0;
        }catch (SQLException e){
        }
        return leagueRemoved;
    }
}
