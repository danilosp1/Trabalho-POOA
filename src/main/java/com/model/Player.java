package com.model;

import com.enums.CourseType;
import com.enums.GenderType;

import java.sql.Blob;

public class Player extends User {
    private CharacterSheet[] sheetsList;
    private SystemRPG[] systemsList;

    public Player(String name, Blob picture, CourseType course, String ra, GenderType genre, int age, String description) {
        super(name, picture, course, ra, genre, age, description);
        this.sheetsList = new CharacterSheet[0];
        this.systemsList = new SystemRPG[0];
    }

    public void createSheet(){}

    public void deleteSheet(){}

    public void changeSheet(){}

    public void requestSubscription(){}

    public CharacterSheet[] getCharacterSheet() {
        return sheetsList;
    }

    public SystemRPG[] getSystemRPG() {
        return systemsList;
    }
}
