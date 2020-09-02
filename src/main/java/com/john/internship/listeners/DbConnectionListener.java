package com.john.internship.listeners;

import com.john.internship.connection.db.DbConnection;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@WebListener
public class DbConnectionListener implements ServletContextListener {

    @Resource(lookup ="java:jboss/datasources/LeagueManager")
    private DataSource dataSource;

    public void contextInitialized(ServletContextEvent sce) {
        Statement statement = null;

        try {
            Connection connection = dataSource.getConnection();

            statement = connection.createStatement();

            System.out.println("INFO: Creating tables");
            statement.execute("create table if not exists team(name varchar(255), teamCode varchar(255))");

            sce.getServletContext().setAttribute("dbConnection", connection);


        }catch (SQLException sqEx){
            sqEx.printStackTrace();
        }finally {
            try {
                if (statement != null)
                    statement.close();

            }catch (SQLException sqlEx2){
                sqlEx2.printStackTrace();
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
