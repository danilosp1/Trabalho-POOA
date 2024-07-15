package com.model;

import com.enums.StatusType;

import java.util.Date;
import java.util.UUID;

public class Campaign {
    private UUID id;
    private String name;
    private int maxPlayers;
    private int minPlayers;
    private Master master;
    private int sessionsNumber;
    private String description;
    private StatusType status;
    private Date startDate;
    private Date endDate;
    private RequestSubscription[] subscriptions;
    private CharacterSheet[] characters;
    private Session[] sessions;
    private SystemRPG systemRPG;

    public Campaign(String name, int maxPlayers, int minPlayers, Master master, int sessionsNumber, String description, StatusType status, Date startDate, Date endDate, RequestSubscription[] subscriptions, CharacterSheet[] characters, Session[] sessions, SystemRPG systemRPG) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.minPlayers = minPlayers;
        this.master = master;
        this.sessionsNumber = sessionsNumber;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.subscriptions = subscriptions;
        this.characters = characters;
        this.sessions = sessions;
        this.systemRPG = systemRPG;
    }

    public void startSession(){}

    public boolean addCharacter(CharacterSheet characterSheet){
        if (characterSheet == null) {
            return false;
        }

        CharacterSheet[] newList = new CharacterSheet[characters.length + 1];
        System.arraycopy(characters, 0, newList, 0, characters.length);
        newList[characters.length] = characterSheet;
        characters = newList;
        return true;
    }

    public boolean removeCharacter(CharacterSheet characterSheet) {
        if (characterSheet == null) {
            return false;
        }

        int index = -1;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i].equals(characterSheet)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }

        CharacterSheet[] newList = new CharacterSheet[characters.length - 1];
        System.arraycopy(characters, 0, newList, 0, index);
        System.arraycopy(characters, index + 1, newList, index, characters.length - index - 1);
        characters = newList;
        return true;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public Master getMaster() {
        return master;
    }

    public int getSessionsNumber() {
        return sessionsNumber;
    }

    public String getDescription() {
        return description;
    }

    public StatusType getStatus() {
        return status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public RequestSubscription[] getSubscriptions() {
        return subscriptions;
    }

    public CharacterSheet[] getCharacters() {
        return characters;
    }

    public Session[] getSessions() {
        return sessions;
    }

    public SystemRPG getSystemRPG() {
        return systemRPG;
    }
}
