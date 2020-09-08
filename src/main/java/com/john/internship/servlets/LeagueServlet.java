package com.john.internship.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.john.internship.connection.db.annotation.SaveToDb;
import com.john.internship.connection.db.bean.LeagueBeanI;
import com.john.internship.model.League;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/League")
public class LeagueServlet extends HttpServlet {

    @EJB
    private LeagueBeanI leagueBean;

    @Inject
    private League league;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().print(mapper.writeValueAsString(leagueBean.show()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BeanUtils.populate(league, req.getParameterMap());
        }catch (Exception ex){
            System.out.println(ex.getCause().getMessage());
        }

        resp.getWriter().print(leagueBean.create(league));

    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext scx = getServletContext();
        Connection dbConnection = (Connection) scx.getAttribute("dbConnection");

        try {
            BeanUtils.populate(league, req.getParameterMap());
        } catch (Exception ex) {
            System.out.println(ex.getCause().getMessage());
        }
        resp.getWriter().print(leagueBean.remove(dbConnection, league));
    }

    protected void doSearch(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        ServletContext scx = getServletContext();
        Connection dbConnection = (Connection) scx.getAttribute("dbConnection");
        String name = req.getParameter("name");
        resp.getWriter().print(leagueBean.search(dbConnection, name));
    }
}

