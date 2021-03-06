package com.john.internship.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "leagues")
@NamedQueries({
        @NamedQuery(name = "League.deleteLeagueById", query = "delete FROM League l where l.id = :id"),
        @NamedQuery(name = "League.findById", query = "SELECT l FROM League l WHERE l.id = :id"),
        @NamedQuery(name = "League.findByName", query = "SELECT l FROM League l WHERE l.leagueName = :name"),
        @NamedQuery(name = "League.select leagues", query = " SELECT l from League l  WHERE l.seasonId = :seasonId order by l.leagueName" ),
})
public class League extends BaseEntity{

    @Column
    private String leagueName;

    @Column
    private String country;

    @Column
    private int level;

    //@ManyToOne
   //private Seasons seasons;

    //@OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
   // private List<Teams>teams = new ArrayList<>();

   // @Formula("(select s.name from seasons s where s.id=id)") //Pending query
    //private String leagueName;

   // @Formula("coalesce(season_id,0)") //Pending subQuery

    @Column
    private int seasonId;

    @Transient
    private String action;


   // public String getName() {
       // return name;
  //  }

   // public void setName(String name) {
    //    this.name = name;
    //}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    //public Seasons getSeasons() {
      //return seasons;
   // }

    //public void setSeasons(Seasons seasons) {
    //  this.seasons = seasons;
   //}

   // @XmlTransient
   // @JsonIgnore
   // public List<Teams> getTeams() {
       // return teams;
    //}


    //public void setTeams(List<Teams> teams) {
      //  this.teams = teams;
  //  }

    public String getLeagueName() {
       return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public int getLeagueId() {
        return seasonId;
    }

    public void setLeagueId(int leagueId) {
        this.seasonId = leagueId;
    }

    //public void addTeam(Teams team){
       // team.setLeague(this);
       // this.teams.add(team);
    //}

    @JsonIgnore
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
