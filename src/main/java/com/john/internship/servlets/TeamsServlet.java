package com.john.internship.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.john.internship.connection.db.bean.TeamsBeanI;
import com.john.internship.model.Teams;
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


@WebServlet("/Teams")
public class TeamsServlet extends HttpServlet {

    @EJB
    private TeamsBeanI teamsBean;

    @Inject
    private Teams teams;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        try {
            if (teams != null && StringUtils.isNotBlank(teams.getAction())
                    && teams.getAction().equalsIgnoreCase("load") && teams.getId() != 0) {
                resp.getWriter().print(mapper.writeValueAsString(teamsBean.load(teams.getId())));

            } else
                resp.getWriter().print(mapper.writeValueAsString(teamsBean.show()));
        } catch (Exception e) {
            e.getCause();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BeanUtils.populate (teams, req.getParameterMap());
        }catch (Exception ex){
            System.out.println(ex.getCause().getMessage());
        }
        try {
            resp.getWriter().print(teamsBean.add(teams));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
