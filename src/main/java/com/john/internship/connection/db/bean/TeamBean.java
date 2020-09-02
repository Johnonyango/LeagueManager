package com.john.internship.connection.db.bean;

import com.john.internship.model.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamBean implements TeamBeanI {
    @Override
    public String add(Connection connection, Team team) {
        if (connection == null)
            return "FAILED: No Connection";

        if (team == null)
            return "FAILED: No Such Team";
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO teams(Name, teamCode, numberOfGames, Points) VALUES(?, ?, ?, ?)");
            st.setString(1, team.getName()==null? null: team.getName());
            st.setString(2, team.getTeamCode()==null? null: team.getTeamCode());
            st.setLong(3, team.getNumberOfGames());
            st.setLong(4, team.getPoints());
            st.executeUpdate();

        }catch (SQLException e){

        }
        return "Success";
    }

    @Override
    public List<Team> show(Connection connection){
        List<Team> teams = new ArrayList<Team>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM teams");
            statement.execute();
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Team team = new Team();
                team.setName(result.getString("Name"));
                team.setTeamCode(result.getString("teamCode"));
                team.setNumberOfGames(result.getLong("numberOfGames"));
                team.setPoints(result.getLong("Points"));

                teams.add(team);
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
    public String update(Connection connection, Team team) {
        return null;
    }

    @Override
    public String remove(Connection connection) {
        return null;
    }
}
