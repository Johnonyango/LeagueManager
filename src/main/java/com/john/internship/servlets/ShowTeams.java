package com.john.internship.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.john.internship.connection.db.DbConnection;
import com.john.internship.logic.TeamLogic;
import com.john.internship.model.Team;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Teams")
public class ShowTeams extends HttpServlet {
    DbConnection dbConnection;
    Team team = new Team();

    @Override
    public void init() throws ServletException {
        ServletContext scx = getServletContext();
        dbConnection = (DbConnection) scx.getAttribute("dbConnection");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        List<Team> teams = new ArrayList<>();

        try {
            PreparedStatement st = this
                    .dbConnection
                    .getConnection()
                    .prepareStatement("SELECT * FROM teams");
            st.execute();
            ResultSet result = st.getResultSet();

            while (result.next()){
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

        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().println(mapper.writeValueAsString(teams));
    }
}
