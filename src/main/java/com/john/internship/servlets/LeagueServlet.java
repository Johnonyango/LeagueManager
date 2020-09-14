package com.john.internship.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.john.internship.connection.db.bean.LeagueBeanI;
import com.john.internship.model.League;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/League")
public class LeagueServlet extends HttpServlet {

    @EJB
    private LeagueBeanI leagueBean;

    @Inject
    private League league;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            resp.getWriter().print(mapper.writeValueAsString(leagueBean.show()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BeanUtils.populate (league, req.getParameterMap());
        }catch (Exception ex){
            System.out.println(ex.getCause().getMessage());
        }
        try {
            resp.getWriter().print(leagueBean.create(league));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

