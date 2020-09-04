package com.john.internship.connection.db.bean;

import com.john.internship.model.Seasons;
import com.john.internship.model.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeasonsBean implements SeasonsBeanI{
    @Override

    public String start(Connection connection, Seasons seasons) {
        return null;
    }

    @Override
    public List<Seasons> show(Connection connection) {
        List<Seasons>seasons = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM seasons");
            statement.execute();
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Seasons season = new Seasons();
                season.setFromYear(result.getDate("from_date"));
                season.setToYear(result.getDate("to_date"));
                season.setStatus(result.getString("status"));

                seasons.add(season);
            }

        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }

        return seasons;
    }
}
