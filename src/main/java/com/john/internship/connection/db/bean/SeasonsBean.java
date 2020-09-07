package com.john.internship.connection.db.bean;

import com.john.internship.model.Seasons;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeasonsBean implements SeasonsBeanI{
    @Override

    public String start(Connection connection, Seasons seasons) {
        if (connection == null)
            return "FAILED: No Connection";

        if (seasons == null)
            return "FAILED: No team added";
        try {

            PreparedStatement st = connection.prepareStatement("INSERT INTO seasons(from_date, to_date, status) VALUES(?, ?, ?)");
            st.setDate(1, (Date) seasons.getFromYear());
            st.setDate(2, (Date) seasons.getToYear());
            st.setString(3, seasons.getId());
            st.setString(4, seasons.getStatus());
            st.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return "Success";
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
