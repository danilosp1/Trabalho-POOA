package com.model.managers;

import com.model.SystemRPG;
import java.util.ArrayList;
import java.util.List;

public class SystemManager {
    private List<SystemRPG> availableSystems = new ArrayList<>();

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

    public void printAvailableSystems() {
        System.out.println("Available Systems: ");
        availableSystems.forEach(system ->
                System.out.println("Sistema: " + system.getName())
        );
        System.out.println("=======================\n");
    }
}