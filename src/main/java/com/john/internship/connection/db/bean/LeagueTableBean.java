package com.john.internship.connection.db.bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.john.internship.model.Game;
import com.john.internship.model.League;
import com.john.internship.model.LeagueTable;
import com.john.internship.model.Teams;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Stateless
@Remote
public class LeagueTableBean implements LeagueTableBeanI {

    @PersistenceContext
    private EntityManager em;



    @Override
    public String add(LeagueTable table) throws Exception {
        if (table == null || table.getName() == null)
            throw new Exception("No valid table name provided");
        em.merge(table);
        return "Success";
    }

    @Override
    public List<LeagueTable> show() {
        return em.createQuery("From LeagueTable leagueTable").getResultList();
    }

    @Override
    public League load(int tableId) throws Exception {
        return em.find(League.class, tableId);
    }

    @Override
    public String search(Connection connection) {
        return null;
    }

    @Override
    public String update(Connection connection, LeagueTable team) {
        return null;
    }

    @Override
    public String remove(int tableId) throws Exception {
        try {
            if (tableId == 0)
                return "invalid Id";

            LeagueTable table = em.find(LeagueTable.class, tableId);
            if (table != null) {
                em.remove(em.merge(table));
            }
            return "successfully deleted";
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return "Operation failed";
    }

    @EJB
    TeamsBeanI teamsBean;

    @Override
    public ArrayList<Game> simulateGame(int leagueId) throws IOException {
        List<Teams> teams = teamsBean.getByLeagueId(leagueId);
        if (teams == null) {
            return null;
        }
        ArrayList<String> vals = new ArrayList<>();
        for (Teams team : teams) {
            vals.add(team.getName());
        }

        /**/
        Collections.shuffle(vals);

        ArrayList<String> al = new ArrayList<>();
        ArrayList<String> al2 = new ArrayList<>();

        /**/
        for (int i = 0; i < vals.size(); i++) {
            if (i < (vals.size() / 2)) {
                al.add(vals.get(i));
            } else {
                al2.add(vals.get(i));
            }
        }
        Collections.shuffle(al);
        Collections.shuffle(al2);

        ArrayList<Game> games = new ArrayList<>();
        for (int i = 0; i < al.size(); i++) {
            Game game = new Game();
            game.setTeam(al.get(i));
            game.setOpponent(al2.get(i));
            game.setTeamS(new Random().nextInt(8));
            game.setOpponentS(new Random().nextInt(8));
            games.add(game);
        }


        games.forEach(game -> {
            try {
                findWinner(game.getTeam(), game.getOpponent(), game.getTeamS(), game.getOpponentS());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return games;
    }

    @Override
    public  List<LeagueTable> findTableByLeagueId(int leagued) throws Exception {
        try {
            Query query = em.createNamedQuery("LeagueTable.getTableByLeagueId", LeagueTable.class);
            query.setParameter("leagueId", leagued);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;    }

    public LeagueTable teamPoints(String team) throws Exception {
        try {
            Query query = em.createNamedQuery("LeagueTable.findPoints", LeagueTable.class);
            query.setParameter("name", team);
            return (LeagueTable) query.getSingleResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updateTable(LeagueTable table) throws Exception {
        try {
            em.merge(table);
            // Query query = em.createNamedQuery("LeagueTable.updateTable", LeagueTable.class);
            //query.setParameter("name", team);
            // query.setParameter("p", points);
            // query.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return "success";
    }

    @Override
    public String findWinner(String teamA, String teamB, int teamAScore, int teamBScore) throws Exception {
        LeagueTable A = teamPoints(teamA);
        LeagueTable B = teamPoints(teamB);

        int teamAPoints = A != null ? A.getPoints() : 0;
        int teamBPoints = B != null ? B.getPoints() : 0;
        if (teamAScore == teamBScore) {
            teamAPoints++;
            teamBPoints++;
        } else if (teamAScore > teamBScore) {
            teamAPoints += 3;
        } else {
            teamBPoints += 3;
        }
        A.setPoints(teamAPoints);
        A.setNumberOfGames(A.getNumberOfGames()+1);
        B.setPoints(teamBPoints);
        B.setNumberOfGames(B.getNumberOfGames()+1);
        updateTable(A);
        updateTable(B);
        return "Success";
    }



}
