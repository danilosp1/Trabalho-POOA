package com.model;

import java.util.Date;

public class NewSystemRequest {
    private Date date;
    private String newSystem;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNewSystem() {
        return newSystem;
    }

    public void setNewSystem(String newSystem) {
        this.newSystem = newSystem;
    }
}
