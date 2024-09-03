package com.model.users;

import com.enums.CourseType;
import com.enums.GenderType;
import com.interfaces.UserInterface;
import com.model.*;
import com.model.managers.CampaignManager;
import com.model.managers.SystemManager;
import com.model.managers.UserManager;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private static List<SystemRPG> availableSystems = new ArrayList<>();
    private static List<Campaign> availableCampaign = new ArrayList<>();
    private static List<UserInterface> usuarios = new ArrayList<>();
    private final CampaignManager campaignManager;
    private final SystemManager systemManager;
    private final UserManager userManager;

    public Admin(String name, CourseType course, String ra, GenderType genre, int age, String description, CampaignManager campaignManager, SystemManager systemManager, UserManager userManager) {
        super(name, course, ra, genre, age, description);
        this.campaignManager = campaignManager;
        this.systemManager = systemManager;
        this.userManager = userManager;
    }

    public static List<UserInterface> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(List<UserInterface> usuarios) {
        Admin.usuarios = usuarios;
    }

    public static void setAvailableCampaign(List<Campaign> availableCampaign) {
        Admin.availableCampaign = availableCampaign;
    }

    public static List<Campaign> getAvailableCampaign() {
        return availableCampaign;
    }

    public static List<SystemRPG> getAvailableSystems() {
        return availableSystems;
    }

    public static void setAvailableSystems(List<SystemRPG> availableSystems) {
        Admin.availableSystems = availableSystems;
    }

    public void createSystem(SystemRPG system) {
        systemManager.createSystem(system);
    }

    public void deleteSystem(SystemRPG system) {
        systemManager.deleteSystem(system);
    }

    public void createCampaign(Campaign campaign) {
        campaignManager.createCampaign(campaign);
    }

    public void deleteCampaign(Campaign campaign) {
        campaignManager.deleteCampaign(campaign);
    }

    public void manageUser(User user, String action) {
        userManager.manageUser(user, action);
    }

    public void printAvailableSystems() {
        systemManager.printAvailableSystems();
    }

    public void printAvailableCampaigns() {
        campaignManager.printAvailableCampaigns();
    }

    public void printUsers() {
        userManager.printUsers();
    }
}
