package com.model.managers;

import com.model.Campaign;

import java.util.ArrayList;
import java.util.List;

public class CampaignManager {

    private List<Campaign> campaigns = new ArrayList<>();

    public void createCampaign(Campaign campaign) {
        if (!campaigns.contains(campaign)) {
            campaigns.add(campaign);
            System.out.println("Campanha " + campaign.getName() + " criada e adicionada à lista de campanhas disponíveis.");
        } else {
            System.out.println("Campanha " + campaign.getName() + " já existe na lista de campanhas disponíveis.");
        }
    }

    public void deleteCampaign(Campaign campaign) {
        if (campaigns.contains(campaign)) {
            campaigns.remove(campaign);
            System.out.println("Campanha " + campaign.getName() + " removida da lista de campanhas disponíveis.");
        } else {
            System.out.println("Campanha " + campaign.getName() + " não encontrada na lista de campanhas disponíveis.");
        }
    }

    public void printAvailableCampaigns() {
        System.out.println("Available Campaigns: ");
        for (int i = 0; i < campaigns.size(); i++) {
            Campaign c = campaigns.get(i);
            System.out.print("Campanha " + (i+1) + ": " + c.getName());
            if (c.getMaster() != null) {
                System.out.println("; Mestre: " + c.getMaster().getName());
            } else {
                System.out.println("; Mestre: Sem mestre definido");
            }
        }
        System.out.println("=======================\n");
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }
}
