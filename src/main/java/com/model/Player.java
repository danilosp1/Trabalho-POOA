package com.model;

import com.enums.CharacterClassType;
import com.enums.CourseType;
import com.enums.GenderType;
import com.enums.RaceType;

import java.util.ArrayList;
import java.util.List;

public class Player extends User {
    private List<CharacterSheet> sheetsList = new ArrayList<>();
    private List<Campaign> campaignList = new ArrayList<>();

    public Player(String name, CourseType course, String ra, GenderType genre, int age, String description) {
        super(name, course, ra, genre, age, description);
    }

    public void createCharacter(String name, int level, GenderType gender, int age, CharacterClassType characterClass, RaceType race, String description) {
        CharacterSheet characterSheet =  new CharacterSheet(name, level, gender, age, characterClass, race, description, this);
        sheetsList.add(characterSheet);
    }

    public void deleteCharacter(CharacterSheet characterSheet) {
        if(characterSheet != null) {
            sheetsList.remove(characterSheet);
        }
    }

    public void changeSheet(List<CharacterSheet> newSheet){
        sheetsList = newSheet;
    }

    public void requestSubscription(){}

    public List<CharacterSheet> getCharacterSheet() {
        return sheetsList;
    }


    // Caso de uso: Gerenciamento de Campanha do Player

    public List<Campaign> getSystemRPG() {
        return campaignList;
    }

    public void addCampaing(Campaign campaign) {
        campaignList.add(campaign);
    }

    public void removeCampaing(Campaign campaign) {
        campaignList.remove(campaign);
    }



    public void printSheetList() {
        System.out.println(this.getName() + "'s characters sheet");
        sheetsList.forEach((sheet) -> {
            System.out.println((sheetsList.indexOf(sheet)+1) + " - " + sheet.getName() +
                    "; Level: " + sheet.getLevel() +
                    "; Gender: " + sheet.getGender() +
                    "; Age: " + sheet.getAge() +
                    "; Class: " + sheet.getCharacterClass() +
                    "; Race: " + sheet.getRace() +
                    "; Desciption: " + sheet.getDescription());
        });
    }

    public void requestSubscription(Campaign campaign, CharacterSheet sheet) {
        if(campaign != null && sheet != null){
            RequestSubscription subscription = new RequestSubscription(sheet, java.time.LocalDate.now().toString(), campaign);
            campaign.addSubscription(subscription);

            System.out.println("Solicitação de inscrição enviada para a campanha " + campaign.getName());
        } else {
            System.out.println("Erro: Campanha ou Ficha inválida.");
        }
    }
}
