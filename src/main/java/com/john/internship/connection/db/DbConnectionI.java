package com.john.internship.connection.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DbConnectionI {
    Connection openConnection() throws SQLException, ClassNotFoundException;
    ResultSet executeQuery(PreparedStatement preparedStatement) throws SQLException;
    ResultSet executeQuery(String sql) throws SQLException;
    boolean execute(PreparedStatement preparedStatement) throws SQLException;
    boolean execute(String sql) throws SQLException;
    void close() throws SQLException;
    Connection getConnection();
}