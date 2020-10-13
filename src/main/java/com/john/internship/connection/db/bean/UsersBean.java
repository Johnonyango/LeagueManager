package com.john.internship.connection.db.bean;

import com.john.internship.model.League;
import com.john.internship.model.Users;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Remote
public class UsersBean {

    @PersistenceContext
    private EntityManager em;

    public Users findUser(String username, String password) {
        try {
            Query query = em.createNamedQuery("Users.findUser", Users.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return (Users) query.getSingleResult();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
