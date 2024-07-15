package com.model;

import java.util.UUID;

public class SystemRPG {
    private UUID id;
    private String name;
    private String rules;

    public SystemRPG(String name, String rules) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.rules = rules;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRules() {
        return rules;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }
}
