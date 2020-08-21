package com.john.internship.servlets;

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
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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


        resp.setContentType("text/html");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<table width='100%'><tr><th>NAME</th><th>TEAM CODE</th><tr>");
        try {
            PreparedStatement st = this
                    .dbConnection
                    .getConnection()
                    .prepareStatement("SELECT * FROM teams");
            st.execute();
            ResultSet result = st.getResultSet();

            while (result.next()){
                stringBuilder.append("<tr><th>" + result.getLong("ID")
                        + "</th><th>" + result.getString("Name") + "</th><th>" + result.getString("teamCode") +
                                "</th><th>" + result.getLong("numberOfGames")+
                                "</th><th>" + result.getLong("Points") +
                        "</th><tr>");
            }

        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }

        stringBuilder.append("</table>");


        PrintWriter printWriter = resp.getWriter();
        printWriter.println(stringBuilder);

    }
}
