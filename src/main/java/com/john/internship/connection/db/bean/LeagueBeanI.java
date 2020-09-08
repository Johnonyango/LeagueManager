package com.john.internship.connection.db.bean;

import com.john.internship.model.League;

import javax.ejb.Remote;
import java.sql.Connection;
import java.util.List;

public interface LeagueBeanI {
    String create(League league);
    List<League> show();
    League search(Connection connection, String name);
    boolean remove(Connection connection, League league);
}
