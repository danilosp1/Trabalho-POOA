package com.model;

import java.util.Date;
import java.util.UUID;

public class RequestSubscription {
    private UUID id;
    public CharacterSheet sheet;
    public Date date;
    public Campaign campaign;

    public RequestSubscription(CharacterSheet sheet, Date date, Campaign campaign) {
        this.id = UUID.randomUUID();
        this.sheet = sheet;
        this.date = date;
        this.campaign = campaign;
    }

    public UUID getId() {
        return id;
    }

    public CharacterSheet getSheet() {
        return sheet;
    }

    public Date getDate() {
        return date;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void acceptSheet(){}

    public void rejectSheet(){}
}
