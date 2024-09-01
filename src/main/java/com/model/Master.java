package com.model;

import com.enums.CourseType;
import com.enums.GenderType;
import com.enums.StatusType;

import java.util.ArrayList;
import java.util.List;


public class Master extends User{
    private List<Campaign> campaignList = new ArrayList<>();

    public Master(String name, CourseType course, String ra, GenderType genre, int age, String description) {
        super(name, course, ra, genre, age, description);
    }



    public void createCampaign(Campaign campaign) {
        campaignList.add(campaign);
    }

    public void deleteCampaign(Campaign campaign) {
        campaignList.remove(campaign);
    }

    public void changeStatus(Campaign campaign, StatusType newStatus) {
        campaign.setStatus(newStatus);
    }

    public List<Player> allPlayers(Campaign campaign) {
        return campaign.getPlayers();
    }



    public void changeCampaign(){}

    public List<Campaign> getCampaignList() {
        return campaignList;
    }
}
