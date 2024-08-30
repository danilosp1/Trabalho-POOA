package com.model;

import com.enums.CourseType;
import com.enums.GenderType;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private List<NewSystemRequest> newSystems = new ArrayList<>();
    private static List<SystemRPG> availableSystems = new ArrayList<>();

    public Admin(String name, CourseType course, String ra, GenderType genre, int age, String description) {
        super(name, course, ra, genre, age, description);
    }

    public void createSystem(SystemRPG system){
        if (!availableSystems.contains(system)) {
            availableSystems.add(system);
            System.out.println("Sistema RPG " + system.getName() + " criado e adicionado à lista de sistemas disponíveis.");
        } else {
            System.out.println("Sistema RPG " + system.getName() + " já existe na lista de sistemas disponíveis.");
        }
    }

    public void deleteSystem(SystemRPG system){
        if (availableSystems.contains(system)) {
            availableSystems.remove(system);
            System.out.println("Sistema RPG " + system.getName() + " removido da lista de sistemas disponíveis.");
        } else {
            System.out.println("Sistema RPG " + system.getName() + " não encontrado na lista de sistemas disponíveis.");
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

    public List<NewSystemRequest> getNewSystems() {
        return newSystems;
    }

    public boolean setNewSystemRequest(NewSystemRequest newSystem) {
        if(newSystem == null){
            return false;
        }
        newSystems.add(newSystem);
        return true;
    }

    public void setNewSystems(List<NewSystemRequest> newSystems) {
        this.newSystems = newSystems;
    }
}
