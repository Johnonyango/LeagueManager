package com.john.internship.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.john.internship.connection.db.DbConnection;
import com.john.internship.model.MessageModel;
import com.john.internship.model.Team;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Teams")
public class ShowTeams extends HttpServlet {
    DbConnection dbConnection;
    PreparedStatement st;
    Team team = new Team();

    @Override
    public void init() throws ServletException {
        ServletContext scx = getServletContext();
        dbConnection = (DbConnection) scx.getAttribute("dbConnection");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("user")==null){
            response.sendRedirect("login.jsp");
            return;
        }
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        String action = request.getParameter("action");
        switch (action) {
            case "show":
                showTeam(request, response);
                break;
            case "insert":
                addTeam(request, response);
                break;
            case "search":
                searchTeam(request, response);
                break;
            case "edit":
                updateTeam(request, response);
                break;
            case "delete":
                removeTeam(request, response);
                break;
            default:
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
                break;
        }
    }

    protected void addTeam(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (dbConnection == null) {
                assert dbConnection != null;
                Connection connection = dbConnection.getConnection();
                st = connection.prepareStatement("INSERT INTO teams(Name, teamCode, numberOfGames, Points) VALUES(?, ?, ?, ?)");
                st.setString(1, "Name");
                st.setString(2, "teamCode");
                st.setString(1, "numberOfGames");
                st.setString(1, "Points");

                PrintWriter writer = resp.getWriter();
                if (dbConnection.execute(st)) {
                    writer.write("successful");
                } else {
                    writer.write("failed");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected void updateTeam(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (dbConnection == null) {
                Connection connection = dbConnection.getConnection();
                st = connection.prepareStatement("update teams set Name = ?, teamCode= ?, numberOfGames =?, Points =?;");
                st.setString(1, "Name");
                st.setString(2, "teamCode");
                st.setString(1, "numberOfGames");
                st.setString(1, "Points");

                PrintWriter writer = resp.getWriter();
                if (dbConnection.execute(st)) {
                    writer.write("successful");
                } else {
                    writer.write("failed");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    protected void showTeam(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        List<Team> teams = new ArrayList<>();
        try {
            PreparedStatement st = this
                    .dbConnection
                    .getConnection()
                    .prepareStatement("SELECT * FROM teams");
            st.execute();
            ResultSet result = st.getResultSet();

            while (result.next()) {
                Team team = new Team();
                team.setName(result.getString("Name"));
                team.setTeamCode(result.getString("teamCode"));
                team.setNumberOfGames(result.getLong("numberOfGames"));
                team.setPoints(result.getLong("Points"));

                teams.add(team);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().println(mapper.writeValueAsString(teams));
    }

    protected void searchTeam(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String teamCode = req.getParameter("teamCode");
            PreparedStatement st = this
                    .dbConnection
                    .getConnection()
                    .prepareStatement("SELECT * FROM teams where teamCode=?");
            st.setString(1,teamCode);
            ResultSet result = dbConnection.executeQuery(st);
            if (result.next()) {
                Team team = new Team();
                team.setName(result.getString("Name"));
                team.setTeamCode(result.getString("teamCode"));
                team.setNumberOfGames(result.getLong("numberOfGames"));
                team.setPoints(result.getLong("Points"));

                ObjectMapper mapper = new ObjectMapper();
                resp.getWriter().println(mapper.writeValueAsString(new MessageModel(true, "team found", team)));
                return;
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().println(mapper.writeValueAsString(new MessageModel(false, "team not found")));
    }

    protected void removeTeam(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String teamCode = req.getParameter("teamCode");
            PreparedStatement st = this
                    .dbConnection
                    .getConnection()
                    .prepareStatement("DELETE FROM teams where teamCode=?");
            dbConnection.execute(st);
            st.setString(1,"teamCode");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("league.jsp");
    }
}