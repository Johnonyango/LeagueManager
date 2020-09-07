package com.john.internship.connection.db.bean;

import com.john.internship.connection.db.annotation.SaveToDb;
import com.john.internship.model.League;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SaveToDb
public class LeagueBean implements LeagueBeanI{

    public String create(Connection connection, League league) {
        if (connection == null)
            return "FAILED: No Connection";

        if (league == null)
            return "FAILED: No team added";
        try {

            PreparedStatement st = connection.prepareStatement("INSERT INTO leagues(name, country, level) VALUES(?, ?, ?)");
            st.setString(1, league.getName()==null? null: league.getName());
            st.setString(2, league.getCountry()==null? null: league.getCountry());
            st.setInt(3, league.getLevel());
            st.executeUpdate();

        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return "Success";
    }

    @Override
    public List<League> show(Connection connection) {
        List<League> leagues = new ArrayList<League>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM leagues");
            statement.execute();
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                League league = new League();
                league.setName(result.getString("name"));
                league.setCountry(result.getString("country"));
                league.setLevel(result.getInt("level"));

                leagues.add(league);
            }

        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }

        return leagues;
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
