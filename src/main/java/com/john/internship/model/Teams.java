package com.john.internship.model;

import java.util.List;

public class Teams {
    private  String name;
    private String code;
    private List opponent;

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

    public List getOpponent() {
        return opponent;
    }

    public void setOpponent(List opponent) {
        this.opponent = opponent;
    }
}
