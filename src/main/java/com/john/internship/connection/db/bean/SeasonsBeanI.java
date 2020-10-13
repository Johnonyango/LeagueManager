package com.john.internship.connection.db.bean;

import com.john.internship.model.Seasons;

import java.util.List;

public interface SeasonsBeanI {
    String start(Seasons seasons) throws Exception;
    List<Seasons> show();
    Seasons load(int seasonId) throws Exception;
    String drop(int seasonId) throws Exception;
    Seasons search(int id) throws Exception;
}
