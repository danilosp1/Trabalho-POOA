package com.model;

import com.enums.CourseType;
import com.enums.GenderType;

import java.sql.Blob;

public class Master extends User{
    private SystemRPG[] systemsList;
    private Campaign[] campaignList;

    public Master(String name, Blob picture, CourseType course, String ra, GenderType genre, int age, String description) {
        super(name, picture, course, ra, genre, age, description);
        this.systemsList = new SystemRPG[0];
        this.campaignList = new Campaign[0];
    }

    public void createCampaign(){}

    public void deleteCampaign(){}

    public void changeCampaign(){}

    public SystemRPG[] getSystemRPG() {
        return systemsList;
    }

    public Campaign[] getCampaign() {
        return campaignList;
    }
}
