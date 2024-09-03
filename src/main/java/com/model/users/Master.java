package com.model.users;

import com.enums.CourseType;
import com.enums.GenderType;
import com.enums.StatusType;
import com.interfaces.Observer;
import com.model.Campaign;

import java.util.ArrayList;
import java.util.List;


public class Master extends User implements Observer {
    private List<Campaign> campaignList = new ArrayList<>();

    public Master(String name, CourseType course, String ra, GenderType genre, int age, String description) {
        super(name, course, ra, genre, age, description);
    }

    public void addCampaign(Campaign campaign) {
        campaignList.add(campaign);
    }

    public void removeCampaign(Campaign campaign) {
        campaignList.remove(campaign);
    }

    public void changeStatus(Campaign campaign, StatusType newStatus) {
        campaign.setStatus(newStatus);
    }

    public List<Player> getAllCampaignPlayers(Campaign campaign) {
        if(getCampaignList().contains(campaign)) {
            return campaignList.get(campaignList.indexOf(campaign)).getPlayers();
        }
        return new ArrayList<>();
    }

    public List<Campaign> getCampaignList() {
        return campaignList;
    }

    public void printCampaignPlayers(Campaign campaign) {
        List<Player> players = getAllCampaignPlayers(campaign);
        if(!players.isEmpty()) {
            System.out.println("Players da campanha " + campaign.getName() + ": ");
            for (int i = 0; i < players.size(); i++) {
                Player p = players.get(i);
                System.out.print("Player " + (i+1));
                System.out.print(": " + p.getName());
                System.out.println(" - " + p.getRa());
            }
            System.out.println("=======================\n");
        } else {
            System.out.println("Mestre não é responsável pela campanha ou não há players ainda.");
        }
    }

    public void printAllCampaign() {
        System.out.println("Lista de campanhas:");
        for (int i = 0; i < getCampaignList().size(); i++) {
            Campaign c = getCampaignList().get(i);
            System.out.print("Campanha " + (i+1));
            System.out.println(": " + c.getName());
        }
        System.out.println("=======================\n");
    }

    @Override
    public void update(String message) {
        System.out.println("Mestre " + this.getName() + " foi notificado: " + message);
    }
}
