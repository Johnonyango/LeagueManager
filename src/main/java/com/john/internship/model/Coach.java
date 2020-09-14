package com.john.internship.model;

import javax.persistence.*;

@Entity
@Table(name = "team_coach")
public class Coach extends BaseEntity {


    @Embedded
    private BioData bioData;

    public BioData getBioData() {
        return bioData;
    }

    public void setBioData(BioData bioData) {
        this.bioData = bioData;
    }
}
