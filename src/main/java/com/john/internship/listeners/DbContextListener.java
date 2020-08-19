package com.john.internship.listeners;


import com.john.internship.connection.db.DbConnection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class DbContextListener implements ServletContextListener {

    DbConnection dbConnection;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            dbConnection = new DbConnection();
            ServletContext scx = sce.getServletContext();
            scx.setAttribute("dbConnection", dbConnection);
            System.out.println("connection successful");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (dbConnection!=null) {
            try {
                dbConnection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
