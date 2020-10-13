package com.john.internship.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.john.internship.model.Game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Test", urlPatterns = {"/test"})
class Test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Test(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        resp.getWriter().println("Hello " + user);
    }

    void Test(HttpServletResponse resp) throws IOException {
        ArrayList<String> vals = new ArrayList();
        vals.add("A");
        vals.add("B");
        vals.add("C");
        vals.add("D");
        vals.add("E");
        vals.add("F");
        vals.add("G");
        vals.add("H");
        vals.add("I");
        vals.add("J");
        vals.add("K");
        vals.add("L");
        vals.add("M");
        vals.add("N");
        vals.add("M");
        vals.add("N");
        vals.add("O");
        vals.add("P");
        vals.add("Q");
        vals.add("R");

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
            System.out.println(game.toString());
        });

        resp.getWriter().write(
                new ObjectMapper().writeValueAsString(games)
        );

    }
}
