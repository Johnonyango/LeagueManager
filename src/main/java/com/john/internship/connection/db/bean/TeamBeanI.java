package com.john.internship.connection.db.bean;

import com.john.internship.model.Team;

import java.sql.Connection;
import java.util.List;

public interface TeamBeanI {
    String add(Connection connection, Team team);
    List<Team> show(Connection connection);
    String search(Connection connection);
    String update(Connection connection, Team team );
    String remove(Connection connection);
}
