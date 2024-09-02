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
        return campaign.getPlayers();
    }

    public List<Campaign> getCampaignList() {
        return campaignList;
    }

    @Override
    public void update(String message) {
        System.out.println("Mestre " + this.getName() + " foi notificado: " + message);
    }
}
