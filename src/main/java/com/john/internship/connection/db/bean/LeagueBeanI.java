package com.john.internship.connection.db.bean;

import com.john.internship.model.League;

import java.sql.Connection;
import java.util.List;

public interface LeagueBeanI {
    String create(Connection connection, League league);
    List<League> show(Connection connection);
    League search(Connection connection, String name);
    boolean remove(Connection connection, League league);
}
