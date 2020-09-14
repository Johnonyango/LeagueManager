package com.john.internship.connection.db.bean;

import com.john.internship.model.League;
import com.john.internship.model.Teams;

import java.util.List;

public interface TeamsBeanI {
    String add(Teams teams) throws Exception;
    List<Teams> show() throws Exception;
    public League search(int teamId) throws Exception;
    String remove(int teamId) throws Exception;
}
