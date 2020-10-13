package com.john.internship.servlets;

import com.john.internship.connection.db.bean.UsersBean;
import com.john.internship.model.Users;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Auth")
public class UserAuthServlet extends HttpServlet {

    //ServletContext scx;
   // Connection dbConnection;
    //@Override
   // public void init() {
       // ServletContext scx = getServletContext();
        //Connection dbConnection = (Connection) scx.getAttribute("dbConnection");
   // }

    @EJB
    private UsersBean usersBean;

    @Inject
    Users users;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        resp.sendRedirect("login.jsp");
        resp.getWriter().println(" You logged out ");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        PrintWriter printWriter = resp.getWriter();
        if (doLogin(username,password, resp, req)){
            printWriter.println("Ok");
            //resp.sendRedirect("./admin/index.jsp");
//            resp.getWriter().println("Login successful " + username);
        }else
            printWriter.println("Failed");
    }
    public boolean doLogin(String username, String password, HttpServletResponse response, HttpServletRequest request){

        Users users = usersBean.findUser(username, password);
        if (users!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user", users);
            return true;
        }
        return false;
    }
    public boolean doLogout(HttpServletRequest req, HttpServletResponse resp){
        if (users!=null){
            HttpSession session = req.getSession();
            session.removeAttribute("user");
            return true;
        }
        return true;
    }
}