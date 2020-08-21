package com.john.internship.logic;

import com.john.internship.connection.db.DbConnection;
import com.john.internship.connection.db.DbConnectionI;
import com.john.internship.model.Team;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamLogic implements TeamInterface {
    DbConnectionI dbConnectionI;

    public TeamLogic() throws SQLException, ClassNotFoundException {
        System.out.println("[" + this.getClass().getSimpleName() + "] getting connection...");
        this.dbConnectionI = new DbConnection();
    }

    @Override
    public boolean add(Team team) throws SQLException {
        PreparedStatement st = this.dbConnectionI
                .getConnection().prepareStatement("INSERT INTO teams(Name, teamCode, numberOfGames, P, Points) VALUES(?, ?, ?, ?,?)");
        st.setString(1, team.getName());
        st.setString(2, team.getTeamCode());
        st.setLong(3, team.getNumberOfGames());
        st.setLong(4, team.getPoints());
        return dbConnectionI.execute(st);
    }

    @Override
    public boolean update(Team team) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Team team) throws SQLException {
        PreparedStatement st = this
                .dbConnectionI
                .getConnection()
                .prepareStatement("DELETE *  FROM teams WHERE teamCode = ?");
        st.setString(1, team.getTeamCode());
        return dbConnectionI.execute(st);
    }


    @Override
    public Team show(String teamCode) throws SQLException {
        PreparedStatement preparedStatement = this
                .dbConnectionI
                .getConnection()
                .prepareStatement("SELECT * FROM teams WHERE teamCode = ?");
        preparedStatement.setString(1, teamCode);
        ResultSet resultSet = dbConnectionI.executeQuery(preparedStatement);
        if(resultSet.next()){
            Team team = new Team();
            team.setId(resultSet.getLong("ID"));
            team.setName(resultSet.getString("Name"));
            team.setTeamCode(resultSet.getString("teamCode"));
            team.setNumberOfGames(resultSet.getLong("numberOfGames"));
            team.setPoints(resultSet.getLong("Points"));
            return team;
        } else
            return null;    }

    @Override
    public List<Team> showAll() throws SQLException {
        PreparedStatement preparedStatement = this
                .dbConnectionI
                .getConnection()
                .prepareStatement("SELECT * FROM teams");
        ResultSet resultSet = dbConnectionI.executeQuery(preparedStatement);
        List<Team> teams = new ArrayList<>();
        while (resultSet.next()){
            Team team = new Team();
            team.setId(resultSet.getLong("ID"));
            team.setName(resultSet.getString("Name"));
            team.setTeamCode(resultSet.getString("teamCode"));
            team.setNumberOfGames(resultSet.getLong("numberOfGames"));
            team.setPoints(resultSet.getLong("Points"));
            teams.add(team);
        }
        return teams;
    }
}
