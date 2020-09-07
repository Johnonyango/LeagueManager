package com.john.internship.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.john.internship.connection.db.bean.LeagueTableBeanI;
import com.john.internship.model.LeagueTable;
import org.apache.commons.beanutils.BeanUtils;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/Table")
public class LeagueTableServlet extends HttpServlet {

    @Inject
    private LeagueTableBeanI leagueTableBean;

    @Inject
    private LeagueTable league;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext scx = getServletContext();
        Connection dbConnection = (Connection) scx.getAttribute("dbConnection");
        resp.setContentType("text/plain");

        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().print(mapper.writeValueAsString(leagueTableBean.show(dbConnection)));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext scx = getServletContext();
        Connection dbConnection = (Connection) scx.getAttribute("dbConnection");

        try {
            BeanUtils.populate (league, req.getParameterMap());
        }catch (Exception ex){
            System.out.println(ex.getCause().getMessage());
        }
        resp.getWriter().print(leagueTableBean.add(dbConnection, league));
    }
}

