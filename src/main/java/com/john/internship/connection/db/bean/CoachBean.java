package com.john.internship.connection.db.bean;

import com.john.internship.model.Coach;


import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Remote
public class CoachBean implements CoachBeanI {

    @PersistenceContext
    private EntityManager em;

    @Override
    public String add(Coach coach) throws Exception {
        if (coach == null || coach.getFirstName() == null)
            throw new Exception("No valid table name provided");
        em.merge(coach);
        return "Success";    }

    @Override
    public List<Coach> show() {
        return em.createQuery("FROM Coach coach").getResultList();
    }

    @Override
    public String delete(int coachId) throws Exception {
        try {
            if (coachId == 0)
                return "invalid Id";

            Coach coach = em.find(Coach.class, coachId);
            if (coach != null){
                em.remove(em.merge(coach));
            }
            return "successfully deleted";
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return "Opertation failed";
    }
}

