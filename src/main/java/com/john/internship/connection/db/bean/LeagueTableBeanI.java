package com.john.internship.connection.db.bean;

import com.john.internship.model.Game;
import com.john.internship.model.League;
import com.john.internship.model.LeagueTable;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public interface LeagueTableBeanI {
    String add(LeagueTable leagueTable) throws Exception;
    List<LeagueTable> show();
    public League load(int tableId) throws Exception;
    String search(Connection connection);
    String update(Connection connection, LeagueTable league );
    String remove(int tableId) throws Exception;
    String findWinner(String teamA, String teamB, int points, int scores) throws Exception;
    String updateTable(LeagueTable table)throws Exception;
    ArrayList<Game> simulateGame(int leagueId) throws IOException;
    List<LeagueTable> findTableByLeagueId(int leagued) throws Exception;
}
