package com.john.internship.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "league_table")
@NamedQueries({
        @NamedQuery(name = "LeagueTable.findPoints", query = "SELECT t FROM LeagueTable t where t.name=:name "),
        @NamedQuery(name = "LeagueTable.updateTable", query = "UPDATE LeagueTable t set t.points=:p where t.name=:name "),
        @NamedQuery(name = "LeagueTable.getTableByLeagueId", query = " SELECT t from LeagueTable t WHERE t.leagueId = :leagueId ORDER BY t.points DESC" ),


})
public class LeagueTable extends BaseEntity{

    @Column
    private String teamCode;

    @Column
    private String name;

    @Column
    private long numberOfGames;

    @Column
    private int points;

    @Column
    private int leagueId;

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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
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
