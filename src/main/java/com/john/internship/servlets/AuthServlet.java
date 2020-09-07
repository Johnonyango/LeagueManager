package com.john.internship.servlets;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Auth")
public class AuthServlet extends HttpServlet {
    ServletContext scx;
    Connection dbConnection;
    @Override
    public void init() {
        ServletContext scx = getServletContext();
        Connection dbConnection = (Connection) scx.getAttribute("dbConnection");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("pwd");
        System.out.println(username);
        if (doLogin(username,password)){
            resp.sendRedirect("admin.jsp");
//            resp.getWriter().println("Login successful " + username);
        }else
            resp.sendRedirect("login.jsp");
    }
    public boolean doLogin(String username, String password){
        try {
            if (dbConnection!=null) {
                PreparedStatement statement = dbConnection.prepareStatement("SELECT * FROM `admins` WHERE name=? && `password`=?");
                statement.setString(1, username);
                statement.setString(2,password);
                ResultSet rs = statement.getResultSet();
                if (rs.next())
                    return true;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }
}