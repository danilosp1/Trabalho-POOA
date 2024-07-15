package com.model;

import java.util.Date;
import java.util.UUID;

public class Session {
    private UUID id;
    private Date date;
    private String description;
    private CharacterSheet[] characters;

    public Session(Date date, String description, CharacterSheet[] characters) {
        this.id = UUID.randomUUID();
        this.date = date;
        this.description = description;
        this.characters = characters;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CharacterSheet[] getCharacters() {
        return characters;
    }
}
