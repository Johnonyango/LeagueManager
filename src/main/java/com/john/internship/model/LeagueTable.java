package com.john.internship.model;

import java.util.List;

public class LeagueTable {
    private long id;
    private String teamCode;
    private String name;
    private long numberOfGames;
    private long points;
    private List opponents;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public List getOpponents() {
        return opponents;
    }

    public void setOpponents(List opponents) {
        this.opponents = opponents;
    }

    public String toStringRow(){
        return "[id: " + this.getId() + ", name: " + this.getName() + ", teamCode: " + this.getTeamCode() + ", numberOfTeams: " + this.getNumberOfGames() + ", Points: " + this.getPoints() + ", Opponents:" +this.getOpponents() + "]";
    }
}
