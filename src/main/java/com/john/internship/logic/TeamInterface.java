package com.john.internship.logic;

import com.john.internship.model.Team;

import java.sql.SQLException;
import java.util.List;

public interface TeamInterface {
    boolean add(Team team) throws SQLException;
    boolean update(Team team) throws SQLException;
    boolean delete(Team team) throws SQLException;
    Team show(String teamCode) throws SQLException;
    List<Team>showAll() throws SQLException;
}
