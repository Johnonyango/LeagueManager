package com.john.internship.connection.db.listeners;

import com.john.internship.connection.db.bean.Inheritance2Test;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InheritanceListener implements ServletContextListener {

    @EJB
    private Inheritance2Test inheritanceTest;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("will now list toyotas");
        inheritanceTest.listToyota("Rav4", 0, 5);
        System.out.println("stopped listing");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }
}
