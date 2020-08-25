package com.john.internship.listeners;

import com.john.internship.connection.db.DbConnection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebListener
public class DbConnectionListener implements ServletContextListener {
    DbConnection dbConnection;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context listening now**************************");
        try {
            dbConnection = new DbConnection();
            ServletContext scx = sce.getServletContext();
            scx.setAttribute("dbConnection", dbConnection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (dbConnection==null)
            return;
        try {
            dbConnection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
