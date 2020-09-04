package com.john.internship.model;


import java.util.Date;

public class Seasons {
    private Date fromYear;
    private Date toYear;
    private String id;
    private String status;

    public Date getFromYear() {
        return fromYear;
    }

    public void setFromYear(Date fromYear) {
        this.fromYear = fromYear;
    }

    public Date getToYear() {
        return toYear;
    }

    public void setToYear(Date toYear) {
        this.toYear = toYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
