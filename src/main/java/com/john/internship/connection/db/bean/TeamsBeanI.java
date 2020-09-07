package com.john.internship.connection.db.bean;

import com.john.internship.model.Teams;

import java.sql.Connection;
import java.util.List;

public interface TeamsBeanI {
    String add(Connection connection, Teams teams);
    List<Teams> show(Connection connection);
    Teams search(Connection connection, String name);
    boolean remove(Connection connection);
}
