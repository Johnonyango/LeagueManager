package com.john.internship.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "seasons_table")
public class Seasons extends BaseEntity{

    @Column
    private Date fromYear;

    @Column
    private Date toYear;

    //@Column
    //@Enumerated(EnumType.STRING)
   // private Status status;

    @Transient
    private String action;

    @OneToMany(mappedBy = "seasons", cascade = CascadeType.ALL)
    List<League> leagues = new ArrayList<>();


    public Date getFromYear() {
        return fromYear;
    }

    public void setFromYear(Date fromYear) {
        this.fromYear = fromYear;
    }

    public Date getToYear() {
        return toYear;
    }

    public void setToYear(Date toYear) {
        this.toYear = toYear;
    }

   // public Status getName() {
       // return status;
    //}

   // public void setStatus(Status status) {
        //this.status = status;
    //}

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @JsonIgnore
    public List<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<League> leagues) {
       this.leagues = leagues;
    }

        public void addLeague(League league){
        league.setSeasons(this);
        this.leagues.add(league);
    }

}