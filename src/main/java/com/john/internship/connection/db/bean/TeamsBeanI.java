package com.john.internship.connection.db.bean;

import com.john.internship.model.League;
import com.john.internship.model.Teams;

import java.util.List;

public interface TeamsBeanI {
    String add(Teams teams) throws Exception;
    List<Teams> show() throws Exception;
    public Teams load(int teamId) throws Exception;
    public Teams searchByName(String name) throws Exception;
    String remove(int teamId) throws Exception;
    int teamPoints(int points) throws Exception;
    List<Teams> getByLeagueId(int leagueId)  ;

}
