package com.john.internship.connection.db.bean;

import com.john.internship.model.League;
import com.john.internship.model.LeagueTable;
import com.john.internship.model.Teams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamsBean implements TeamsBeanI {
    @Override
    public List<Teams> show(Connection connection) {
        List<Teams> teams = new ArrayList<Teams>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM teams");
            statement.execute();
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Teams team = new Teams();
                team.setName(result.getString("name"));
                team.setCode(result.getString("teamCode"));
                teams.add(team);
            }

        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return teams;
    }

    @Override
    public String add(Connection connection, Teams teams) {
        if (connection == null)
            return "FAILED: No Connection";

        if (teams == null)
            return "FAILED: No team added";
        try {

            PreparedStatement st = connection.prepareStatement("INSERT INTO teams(name, code) VALUES(?, ?)");
            st.setString(1, teams.getName()==null? null: teams.getName());
            st.setString(2, teams.getCode()==null? null: teams.getCode());
            st.executeUpdate();

        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return "Success";    }

    @Override
    public Teams search(Connection connection, String name) {

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM teams where code=?");
            statement.setString(1, name);
            statement.execute();
            ResultSet result = statement.getResultSet();

            if (result.next()) {
                Teams teams = new Teams();
                teams.setName(result.getString("name"));
                teams.setCode(result.getString("code"));
                return  teams;
            }

        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean remove(Connection connection) {
        boolean teamRemoved = false;
        String deleteQuery = "delete from teams where code = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            statement.execute();
            statement.setString(1, "code");
            teamRemoved =statement.executeUpdate()>0;
        }catch (SQLException e){
        }
        return teamRemoved;
    }
}

