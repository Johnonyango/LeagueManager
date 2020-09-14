package com.john.internship.connection.db.bean;

import com.john.internship.model.League;

import javax.ejb.Remote;
import java.sql.Connection;
import java.util.List;

public interface LeagueBeanI {

    public League load(int leagueId) throws Exception;
    String create(League league) throws Exception;
    List<League> show() throws Exception;
    public League search(int leagueId) throws Exception;
    public String remove(int leagueId) throws Exception;
}
