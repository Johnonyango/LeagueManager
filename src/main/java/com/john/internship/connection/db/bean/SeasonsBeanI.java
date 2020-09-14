package com.john.internship.connection.db.bean;

import com.john.internship.model.Seasons;

import java.sql.Connection;
import java.util.List;

public interface SeasonsBeanI {
    String start(Seasons seasons) throws Exception;
    List<Seasons> show();
    String drop(int seasonId) throws Exception;

}
