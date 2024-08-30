package com.model;

import java.util.Date;

public class NewSystemRequest {
    private String date;
    private String newSystem;

    public NewSystemRequest(String date, String name) {
        this.date = date;
        this.newSystem = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNewSystem() {
        return newSystem;
    }

    public void setNewSystem(String newSystem) {
        this.newSystem = newSystem;
    }
}
