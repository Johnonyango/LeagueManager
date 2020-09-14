package com.john.internship.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.john.internship.connection.db.annotation.SaveToDb;
import com.john.internship.connection.db.bean.SeasonsBeanI;
import com.john.internship.model.Seasons;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

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


@WebServlet("/Seasons")
public class SeasonsServlet extends HttpServlet {

    @EJB
    private SeasonsBeanI seasonsBean;

    @Inject
    private Seasons seasons;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (seasons != null && StringUtils.isNotBlank(seasons.getAction())
                    && seasons.getAction().equalsIgnoreCase("load") && seasons.getId() != 0) {
                resp.getWriter().print(mapper.writeValueAsString(seasonsBean.load(seasons.getId())));

            } else
                resp.getWriter().print(mapper.writeValueAsString(seasonsBean.show()));
        } catch (Exception e) {
            e.getCause();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BeanUtils.populate (seasons, req.getParameterMap());
        }catch (Exception ex){
            System.out.println(ex.getCause().getMessage());
        }
        try {
            resp.getWriter().print(seasonsBean.start(seasons));
        } catch (Exception e) {
            e.printStackTrace();
        }
}
}

