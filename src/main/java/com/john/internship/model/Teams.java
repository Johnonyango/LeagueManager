package com.john.internship.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Formula;

import javax.persistence.*;


@Entity
@Table(name = "teams_table")
@NamedQueries({
        @NamedQuery(name = "Teams.findByName", query = "SELECT t FROM Teams t WHERE t.name = :name"),
        @NamedQuery(name = "Teams.getTeamsByLeagueId", query = " SELECT t from Teams t WHERE t.leagueId = :leagueId" ),

})
public class Teams extends BaseEntity {

    @Column
    private  String name;

    @Column
    private String code;

    //@ManyToOne
    //private League league;

    //@Formula("(select lig.leagueName from leagues lig where lig.id=league_id)") //Pending query
    @Column
    private String leagueName;

    //@Formula("coalesce(league_id,0)") //Pending subQuery
    @Column
    private int leagueId;

    @Column
    @Enumerated(EnumType.STRING)
    private Outcome outcome;

    @Transient
    private String action;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

   // @JsonIgnore
   // public League getLeague() {
     //   return league;
   // }

   ///public void setLeague(League league) {
      // this.league = league;
   ///}

    public String getLeagueName() {
        return leagueName;
   }

    public void setLeagueName(String leagueName) {
       this.leagueName = leagueName;
   }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }
}
