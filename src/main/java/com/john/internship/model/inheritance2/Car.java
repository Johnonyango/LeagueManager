package com.john.internship.model.inheritance2;

import com.john.internship.model.BaseEntity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("N_A")
@Table(name = "cars")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Car extends BaseEntity {

    @Column(name = "car_name")
    private String name;

    @Column(name = "body_type")
    private String bodyType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
}
