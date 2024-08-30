package com.model;
import com.enums.CharacterClassType;
import com.enums.GenderType;
import com.enums.RaceType;

import java.sql.Blob;
import java.util.UUID;

public class CharacterSheet {
    private UUID id;
    private String name;
    private int level;
    private GenderType gender;
    private int age;
    private CharacterClassType characterClass;
    private RaceType race;
    private String description;
    private Player player;

    public CharacterSheet(String name, int level, GenderType gender, int age, CharacterClassType characterClass, RaceType race, String description, Player player) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.level = level;
        this.gender = gender;
        this.age = age;
        this.characterClass = characterClass;
        this.race = race;
        this.description = description;
        this.player = player;
    }

    public String sheetInfos() {
        return "Informações da Ficha: " + this.getName() + "\nNível: " + this.getLevel() + "\nGênero: " + this.getGender()
                + "\nIdade: " + this.getAge() + "\nClasse: " + this.getCharacterClass() + "\nRaça: " + this.getRace() + "\nDescrição: "
                + this.getDescription();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public GenderType getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public CharacterClassType getCharacterClass() {
        return characterClass;
    }

    public RaceType getRace() {
        return race;
    }

    public String getDescription() {
        return description;
    }

    public Player getPlayer() {
        return player;
    }
}
