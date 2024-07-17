package com.model;

import com.enums.CharacterClassType;
import com.enums.CourseType;
import com.enums.GenderType;
import com.enums.RaceType;

import java.util.Scanner;
import java.sql.Blob;

public class Player extends User {
    private CharacterSheet[] sheetsList;
    private SystemRPG[] systemsList;

    public Player(String name, Blob picture, CourseType course, String ra, GenderType genre, int age, String description) {
        super(name, picture, course, ra, genre, age, description);
        this.sheetsList = new CharacterSheet[0];
        this.systemsList = new SystemRPG[0];
    }

    public void createCharacter(String name, int level, GenderType gender, int age, CharacterClassType characterClass, RaceType race, Blob picture, String description) {
        CharacterSheet[] newList = new CharacterSheet[sheetsList.length + 1];
        System.arraycopy(sheetsList, 0, newList, 0, sheetsList.length);
        newList[sheetsList.length] = new CharacterSheet(name, level, gender, age, characterClass, race, picture, description, this);
        sheetsList = newList;
    }

    public void deleteCharacter() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < sheetsList.length; i++) {
            System.out.println((i+1) + " - " + sheetsList[i].getName() + " - " + sheetsList[i].getCharacterClass());
        }
        System.out.println("Insira qual deseja remover");
        int index = sc.nextInt() - 1;

        if (index > 0 && index < sheetsList.length) {
            CharacterSheet[] newList = new CharacterSheet[sheetsList.length - 1];
            for (int i = 0, j = 0; i < sheetsList.length; i++) {
                if (i != index) {
                    newList[j++] = sheetsList[i];
                }
            }
            sheetsList = newList;
            return;
        }
        System.out.println("Personagem inválido.");
    }

    public void createSheet(){}

    public void deleteSheet(){
        sheetsList = new CharacterSheet[0];
    }

    public void changeSheet(CharacterSheet [] newSheet){
        sheetsList = newSheet;
    }

    public void requestSubscription(){}

    public CharacterSheet[] getCharacterSheet() {
        return sheetsList;
    }

    public SystemRPG[] getSystemRPG() {
        return systemsList;
    }

    public void printSheetList() {
        System.out.println(this.getName() + "'s characters sheet");
        for (int i = 0; i < sheetsList.length; i++) {
            System.out.println((i+1) + " - " + sheetsList[i].getName() +
            "; Level: " + sheetsList[i].getLevel() + 
            "; Gender: " + sheetsList[i].getGender() + 
            "; Age: " + sheetsList[i].getAge() + 
            "; Class: " + sheetsList[i].getCharacterClass() + 
            "; Race: " + sheetsList[i].getRace() + 
            "; Desciption: " + sheetsList[i].getDescription());
        }
    }
}
