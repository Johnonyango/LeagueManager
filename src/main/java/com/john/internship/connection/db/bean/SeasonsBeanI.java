package com.john.internship.connection.db.bean;

import com.john.internship.model.Seasons;

import java.sql.Connection;
import java.util.List;

public interface SeasonsBeanI {
    String start(Connection connection, Seasons seasons);
    List<Seasons> show(Connection connection);
}
