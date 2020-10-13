package com.john.internship.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "seasons_table")
@NamedQueries({
        @NamedQuery(name = "Seasons.findById", query = "SELECT s FROM Seasons s WHERE s.id = :id"),
})
public class Seasons extends BaseEntity{

    @Column
    private Date fromYear;

    @Column
    private Date toYear;

    //@Column
    //@Enumerated(EnumType.STRING)
   private String status;

    @Transient
    private String action;

    //@OneToMany(mappedBy = "seasons", cascade = CascadeType.ALL)
   // List<League> leagues = new ArrayList<>();


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

   //@XmlTransient
   // @JsonIgnore
    //public List<League> getLeagues() {
      // return leagues;
   //}

   // public void setLeagues(List<League> leagues) {
     // this.leagues = leagues;
   //}

       // public void addLeague(League league){
      // league.setSeasons(this);
      //  this.leagues.add(league);
   // }

}