package com.john.internship.model;

public class MessageModel {
    private String message;
    private boolean status;
    Object object;

    public MessageModel(boolean successful,String message,  Object object) {
        this.message = message;
        this.status = successful;
        this.object = object;
    }

    public MessageModel(boolean successful,String message) {
        this.message = message;
        this.status = successful;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }

    public Object getObject() {
        return object;
    }
}
