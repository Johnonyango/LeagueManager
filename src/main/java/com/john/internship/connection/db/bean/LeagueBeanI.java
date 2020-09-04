package com.john.internship.connection.db.bean;

import com.john.internship.model.League;
import com.john.internship.model.Team;

import java.sql.Connection;
import java.util.List;

public interface LeagueBeanI {
    String create(Connection connection, League league);
    List<League> show(Connection connection);
    String search(Connection connection);
    boolean remove(Connection connection, League league);
}
