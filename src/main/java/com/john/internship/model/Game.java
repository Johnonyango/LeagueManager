/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.john.internship.model;


import java.io.Serializable;

public class Game implements Serializable {

    String team;
    String opponent;
    int teamS;
    int opponentS;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public int getTeamS() {
        return teamS;
    }

    public void setTeamS(int teamS) {
        this.teamS = teamS;
    }

    public int getOpponentS() {
        return opponentS;
    }

    public void setOpponentS(int opponentS) {
        this.opponentS = opponentS;
    }

    @Override
    public String toString() {
        return getTeam() + " " + getTeamS() + " : " + getOpponentS() + " " + getOpponent();
    }

}
