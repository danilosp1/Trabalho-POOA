package com.model;

import com.enums.CourseType;
import com.enums.GenderType;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private static List<SystemRPG> availableSystems = new ArrayList<>();
    private static List<Campaign> availableCampaign = new ArrayList<>();
    private static List<User> usuarios = new ArrayList<>();

    public Admin(String name, CourseType course, String ra, GenderType genre, int age, String description) {
        super(name, course, ra, genre, age, description);
    }

    public static void setAvailableCampaign(List<Campaign> availableCampaign) {
        Admin.availableCampaign = availableCampaign;
    }

    public static List<Campaign> getAvailableCampaign() {
        return availableCampaign;
    }

    public static List<User> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(List<User> usuarios) {
        Admin.usuarios = usuarios;
    }

    public static List<SystemRPG> getAvailableSystems() {
        return availableSystems;
    }

    public static void setAvailableSystems(List<SystemRPG> availableSystems) {
        Admin.availableSystems = availableSystems;
    }

    public static void createSystem(SystemRPG system){
        if (!availableSystems.contains(system)) {
            availableSystems.add(system);
            System.out.println("Sistema RPG " + system.getName() + " criado e adicionado à lista de sistemas disponíveis.");
        } else {
            System.out.println("Sistema RPG " + system.getName() + " já existe na lista de sistemas disponíveis.");
        }
    }

    public static void deleteSystem(SystemRPG system){
        if (availableSystems.contains(system)) {
            availableSystems.remove(system);
            System.out.println("Sistema RPG " + system.getName() + " removido da lista de sistemas disponíveis.");
        } else {
            System.out.println("Sistema RPG " + system.getName() + " não encontrado na lista de sistemas disponíveis.");
        }
    }

    public static void createCampaign(Campaign campaign){
        if (!availableCampaign.contains(campaign)) {
            availableCampaign.add(campaign);
            System.out.println("Campanha " + campaign.getName() + " criada e adicionada à lista de campanhas disponíveis.");
        } else {
            System.out.println("Campanha " + campaign.getName() + " já existe na lista de campanhas disponíveis.");
        }
    }

    public static void deleteCampaign(Campaign campaign){
        if (availableCampaign.contains(campaign)) {
            availableCampaign.remove(campaign);
            System.out.println("Campanha " + campaign.getName() + " removida da lista de campanhas disponíveis.");
        } else {
            System.out.println("Campanha " + campaign.getName() + " não encontrada na lista de campanhas disponíveis.");
        }
    }

    public void manageUser(User user, String acao){
        switch (acao.toLowerCase()) {
            case "suspender":
                System.out.println("Usuário " + user.getName() + " suspenso.");
                user.setActive(false);
                break;
            case "reativar":
                System.out.println("Usuário " + user.getName() + " reativado.");
                user.setActive(true);
                break;
            default:
                System.out.println("Ação desconhecida para gerenciar o usuário.");
        }
    }

    public static void printAvailableSystems() {
        System.out.println("Available Systems: ");
        for (int i = 0; i < availableSystems.size(); i++) {
            System.out.println("Sistema " + i+1 + ": " + availableSystems.get(i).getName());
        }
        System.out.println("=======================\n");
    }

    public static void printAvailableCampaign() {
        System.out.println("Available Campaign: ");
        for (int i = 0; i < availableCampaign.size(); i++) {
            Campaign c = availableCampaign.get(i);
            System.out.print("Campanha " + i+1 + ": " + c.getName());
            if (c.getMaster() != null) {
                System.out.println("; Mestre:" + c.getMaster().getName());
            } else {
                System.out.println("; Mestre: Sem mestre definido");
            }
        }
        System.out.println("=======================\n");
    }


}
