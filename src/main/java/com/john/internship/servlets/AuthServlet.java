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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Auth")
public class AuthServlet extends HttpServlet {
    DbConnection dbConnection;
    @Override
    public void init() throws ServletException {
        ServletContext scx = getServletContext();
        dbConnection = (DbConnection) scx.getAttribute("dbConnection");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("pwd");
        System.out.println(username);
        if (doLogin(username,password)){
            resp.sendRedirect("home.jsp");
//            resp.getWriter().println("Login successful " + username);
        }else
            resp.getWriter().println("Invalid credentials" );
    }
    public boolean doLogin(String username, String password){
        try {
            if (dbConnection!=null) {
                Connection connection = dbConnection.getConnection();
                PreparedStatement st = connection.prepareStatement("SELECT * FROM `teachers` WHERE name=?");
                st.setString(1, username);
                ResultSet rs = dbConnection.executeQuery(st);
                if (rs.next())
                    return true;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }
}
