package com.john.internship.connection.db.bean;

import com.john.internship.model.LeagueTable;

import java.sql.Connection;
import java.util.List;

public interface LeagueTableBeanI {
    String add(Connection connection, LeagueTable league);
    List<LeagueTable> show(Connection connection);
    String search(Connection connection);
    String update(Connection connection, LeagueTable league );
    String remove(Connection connection);
}