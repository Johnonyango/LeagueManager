package com.john.internship.servlets;

import com.john.internship.connection.db.DbConnection;

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
import java.sql.SQLException;

@WebServlet("/Update")
public class UpdateTeams extends HttpServlet {
    DbConnection dbConnection;
    PreparedStatement st;

    @Override
    public void init() throws ServletException {
        ServletContext scx = getServletContext();
        dbConnection = (DbConnection) scx.getAttribute("dbConnection");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (dbConnection == null) {
                Connection connection = dbConnection.getConnection();
                st = connection.prepareStatement("INSERT INTO teams(Name, teamCode, numberOfGames, Points) VALUES(?, ?, ?, ?)");
                st.setString(1, "Name");
                st.setString(2, "teamCode");
                st.setString(1, "numberOfGames");
                st.setString(1, "Points");

                PrintWriter writer = resp.getWriter();
                if (dbConnection.execute(st)) {
                    writer.write("successful");
                }else {
                   writer.write("failed");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
