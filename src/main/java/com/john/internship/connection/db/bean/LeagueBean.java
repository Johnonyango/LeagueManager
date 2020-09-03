package com.john.internship.connection.db.bean;

import com.john.internship.connection.db.annotation.SaveToDb;
import com.john.internship.model.League;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SaveToDb
public class LeagueBean implements LeagueBeanI{

    public String create(Connection connection, League league) {
        if (connection == null)
            return "FAILED: No Connection";

        if (league == null)
            return "FAILED: No team added";
        try {

            PreparedStatement st = connection.prepareStatement("INSERT INTO leagues(name, country, level,) VALUES(?, ?, ?)");
            st.setString(1, league.getName()==null? null: league.getName());
            st.setString(2, league.getCountry()==null? null: league.getCountry());
            st.setInt(3, league.getLevel());
            st.executeUpdate();

        }catch (SQLException sqlEx){
            return sqlEx.getCause().getMessage();

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
    public String search(Connection connection) {
        return null;
    }

    @Override
    public String remove(Connection connection) {
        return null;
    }
}
