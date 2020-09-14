package com.john.internship.model;

import com.fasterxml.jackson.databind.JsonSerializable;

import javax.persistence.*;

@Entity
@Table(name = "team_player")
public class Player extends BaseEntity{

    @Embedded
    private BioData bioData;

    public BioData getBioData() {
        return bioData;
    }

    public void setBioData(BioData bioData) {
        this.bioData = bioData;
    }
}
