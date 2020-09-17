package com.john.internship.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.john.internship.connection.db.bean.LeagueTableBeanI;
import com.john.internship.model.LeagueTable;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.inject.Inject;
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
    private LeagueTable table;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        try {
            if (table != null && StringUtils.isNotBlank(table.getAction())
                    && table.getAction().equalsIgnoreCase("load") && table.getId() != 0) {
                resp.getWriter().print(mapper.writeValueAsString(leagueTableBean.load(table.getId())));

            } else
                resp.getWriter().print(mapper.writeValueAsString(leagueTableBean.show()));
        } catch (Exception e) {
            e.getCause();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BeanUtils.populate (table, req.getParameterMap());
        }catch (Exception ex){
            System.out.println(ex.getCause().getMessage());
        }
        try {
            resp.getWriter().print(leagueTableBean.add(table));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

