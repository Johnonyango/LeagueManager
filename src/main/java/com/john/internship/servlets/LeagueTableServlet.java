package com.john.internship.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.john.internship.connection.db.bean.LeagueTableBeanI;
import com.john.internship.model.LeagueTable;
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

@WebServlet("/Table")
public class LeagueTableServlet extends HttpServlet {

    @EJB
    private LeagueTableBeanI leagueTableBean;

    @Inject
    private LeagueTable league;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().print(mapper.writeValueAsString(leagueTableBean.show()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BeanUtils.populate (league, req.getParameterMap());
        }catch (Exception ex){
            System.out.println(ex.getCause().getMessage());
        }
        try {
            resp.getWriter().print(leagueTableBean.add(league));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

