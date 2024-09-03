package com.model;

import com.enums.CourseType;
import com.enums.GenderType;
import com.interfaces.UserInterface;
import com.model.managers.CampaignManager;
import com.model.managers.SystemManager;
import com.model.managers.UserManager;
import com.model.users.Admin;
import com.model.users.Master;
import com.model.users.Player;

public class UserFactory {

    private static CampaignManager campaignManager = new CampaignManager();
    private static SystemManager systemManager = new SystemManager();
    private static UserManager userManager = new UserManager();

    public static UserInterface createUser(String type, String name, CourseType course, String ra, GenderType genre, int age, String description) {
        switch (type.toLowerCase()) {
            case "administrador":
                return new Admin(name, course, ra, genre, age, description, campaignManager, systemManager, userManager);
            case "jogador":
                return new Player(name, course, ra, genre, age, description);
            case "mestre":
                return new Master(name, course, ra, genre, age, description);
            default:
                throw new IllegalArgumentException("Tipo de usuário desconhecido: " + type);
        }
    }
}