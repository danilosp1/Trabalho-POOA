package com.model;

import java.util.*;

public class Session {
    private final UUID id;
    private String date;
    private String description;
    private final List<CharacterSheet> characters = new ArrayList<CharacterSheet>();
    private boolean finished;

    public Session(String date, String description) {
        this.id = UUID.randomUUID();
        this.date = date;
        this.description = description;
        this.finished = false;
    }

    public boolean addCharacter(CharacterSheet characterSheet){
        if (characterSheet == null) {
            return false;
        }

        characters.add(characterSheet);
        return true;
    }

    public boolean removeCharacter(CharacterSheet characterSheet) {
        if (characterSheet != null && characters.contains(characterSheet)) {
            characters.remove(characterSheet);
            return true;

        }
        return false;
    }

    public void changeInfos(String newDate, String newDescription) {
        if (newDate != null && !newDate.isEmpty()) {
            this.setDate(newDate);
        }
        if (newDescription != null && !newDescription.isEmpty()) {
            this.setDescription(newDescription);
        }
        System.out.println("Informações da sessão alteradas com sucesso.");
    }

    public UUID getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isFinished() {
        return finished;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CharacterSheet> getCharacters() {
        return characters;
    }
}
