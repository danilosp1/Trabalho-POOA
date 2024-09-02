package com.model.users;

import com.enums.CharacterClassType;
import com.enums.CourseType;
import com.enums.GenderType;
import com.enums.RaceType;
import com.interfaces.Observer;
import com.model.Campaign;
import com.model.CharacterSheet;

import java.util.ArrayList;
import java.util.List;

public class Player extends User implements Observer {
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

    public void setSheetsList(List<CharacterSheet> newSheet){
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
        campaign.addPlayer(this);

        if (campaign.getMaster() != null) {
            campaign.attach(campaign.getMaster());
        }
    }

    public void removeCampaing(Campaign campaign) {
        campaignList.remove(campaign);
        campaign.removePlayer(this);
    }

    public void printCampaign() {
        System.out.println("Available Campaign: ");
        for (int i = 0; i < campaignList.size(); i++) {
            Campaign c = campaignList.get(i);
            System.out.print("Campanha " + (i+1) + ": " + c.getName());
            if (c.getMaster() != null) {
                System.out.println("; Mestre:" + c.getMaster().getName());
            } else {
                System.out.println("; Mestre: Sem mestre definido");
            }
        }
        System.out.println("=======================\n");
    }



    public void printSheetsList() {
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

    @Override
    public void update(String message) {
        System.out.println("Jogador " + this.getName() + " foi notificado: " + message);
    }
}
