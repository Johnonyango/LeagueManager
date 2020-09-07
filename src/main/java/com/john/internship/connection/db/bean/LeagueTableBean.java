package com.john.internship.connection.db.bean;

import com.john.internship.model.LeagueTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeagueTableBean implements LeagueTableBeanI {
    @Override
    public String add(Connection connection, LeagueTable league) {
        if (connection == null)
            return "FAILED: No Connection";

        if (league == null)
            return "FAILED: No team added";
        try {

            PreparedStatement st = connection.prepareStatement("INSERT INTO teams(name, teamCode, numberOfGames, Points) VALUES(?, ?, ?,?)");
            st.setString(1, league.getName()==null? null: league.getName());
            st.setString(2, league.getTeamCode()==null? null: league.getTeamCode());
            st.setLong(3, league.getNumberOfGames());
            st.setLong(4, league.getPoints());
            st.executeUpdate();

        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return "Success";
    }

    @Override
    public List<LeagueTable> show(Connection connection){
        List<LeagueTable> teams = new ArrayList<LeagueTable>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM teams");
            statement.execute();
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                LeagueTable league = new LeagueTable();
                league.setName(result.getString("name"));
                league.setTeamCode(result.getString("teamCode"));
                league.setNumberOfGames(result.getLong("numberOfGames"));
                league.setPoints(result.getLong("points"));

                teams.add(league);
            }

        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }

        return teams;
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
