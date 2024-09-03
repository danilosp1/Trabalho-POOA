package org.example;

import com.enums.*;
import com.interfaces.UserInterface;
import com.model.*;
import com.model.managers.CampaignManager;
import com.model.managers.SystemManager;
import com.model.managers.UserManager;
import com.model.users.Admin;
import com.model.users.Master;
import com.model.users.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<UserInterface> usuarios = new ArrayList<>();
    private static List<SystemRPG> sistemasDisponiveis = new ArrayList<>();
    private static List<Campaign> campanhas = new ArrayList<>();
    private static UserInterface usuarioLogado = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        main1();
    }

    private static void main1() {
        CampaignManager campaignManager = new CampaignManager();
        SystemManager systemManager = new SystemManager();
        UserManager userManager = new UserManager();

        Admin admin = (Admin) UserFactory.createUser("administrador", "admin", CourseType.CIENCIA_COMPUTACAO, "811164", GenderType.MASCULINO, 20, "...");
        Master master1 = (Master) UserFactory.createUser("mestre", "master1", CourseType.CIENCIAS, "873182", GenderType.MASCULINO, 18, "...");
        Player player1 = (Player) UserFactory.createUser("jogador", "player1", CourseType.DIREITO, "424155", GenderType.FEMININO, 22, "...");
        Player player2 = (Player) UserFactory.createUser("jogador", "player2", CourseType.ENGENHARIA, "744556", GenderType.FEMININO, 30, "...");
        Player player3 = (Player) UserFactory.createUser("jogador", "player3", CourseType.FISICA, "955665", GenderType.MASCULINO, 17, "...");

        userManager.addUser(admin);
        userManager.addUser(master1);
        userManager.addUser(player1);
        userManager.addUser(player2);
        userManager.addUser(player3);

        SystemRPG sistema1 = new SystemRPG("sistema1", "...");
        SystemRPG sistema2 = new SystemRPG("sistema2", "...");
        SystemRPG sistema3 = new SystemRPG("sistema3", "...");

        systemManager.createSystem(sistema1);
        systemManager.createSystem(sistema2);

        Campaign c1 = new Campaign("campanha1", 10, 5, master1, 3, "...", StatusType.ATIVA, "01/01/2025", "30/01/2025", sistema1);
        Campaign c2 = new Campaign("campanha2", 20, 10, master1, 5, "...", StatusType.ATIVA, "01/01/2025", "30/01/2025", sistema2);
        Campaign c3 = new Campaign("campanha3", 20, 10, master1, 5, "...", StatusType.ATIVA, "01/01/2025", "30/01/2025", sistema2);

        campaignManager.createCampaign(c1);
        campaignManager.createCampaign(c2);

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Caso de Uso 1: Admin gerenciar Campanhas");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        campaignManager.printAvailableCampaigns();
        campaignManager.deleteCampaign(c1);
        campaignManager.createCampaign(c3);
        campaignManager.printAvailableCampaigns();

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Caso de Uso 2: Admin gerenciar Sistemas");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        systemManager.printAvailableSystems();
        systemManager.deleteSystem(sistema1);
        systemManager.createSystem(sistema3);
        systemManager.printAvailableSystems();

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Caso de Uso 3: Mestre gerenciar Campanhas");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        master1.addCampaign(c1);
        master1.addCampaign(c2);
        player1.addCampaing(c1);
        master1.changeStatus(c1, StatusType.FINALIZADA);
        master1.printCampaignPlayers(c1);
        master1.printAllCampaign();
        master1.removeCampaign(c1);

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Caso de Uso 4: Player gerencia campanhas");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        player1.addCampaing(c2);
        player1.printCampaign();
        master1.changeStatus(c1, StatusType.CANCELADA);
        player1.removeCampaing(c1);
        player1.printCampaign();
    }
}