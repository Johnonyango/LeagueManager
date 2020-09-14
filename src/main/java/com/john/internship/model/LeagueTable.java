package com.john.internship.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "league_table")
public class LeagueTable extends BaseEntity{


    @Column
    private String teamCode;

    @Column
    private String name;

    @Column
    private long numberOfGames;

    @Column
    private long points;

//    @OneToOne(mappedBy = "leagueTable", cascade = CascadeType.ALL)
//    List<League>leagues = new ArrayList<>();

    @Transient
    private String action;

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(long numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

//    @JsonIgnore
//    public List<League> getLeagues() {
//        return leagues;
//    }

//    public void setLeagues(List<League> leagues) {
//        this.leagues = leagues;
//    }

    @JsonIgnore
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

//    public void addLeague(League league){
//        league.setLeagueTable(this);
//        this.leagues.add(league);
//    }
}
