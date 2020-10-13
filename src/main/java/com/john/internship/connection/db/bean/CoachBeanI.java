package com.john.internship.connection.db.bean;

import com.john.internship.model.Coach;
import com.john.internship.model.League;

import java.util.List;

public interface CoachBeanI {
    String add(Coach coach) throws Exception;
    public String delete(int coachId) throws Exception;

    public List<Coach>show();
}
