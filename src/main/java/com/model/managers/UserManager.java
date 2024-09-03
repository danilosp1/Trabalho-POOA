package com.model.managers;

import com.model.users.User;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
            System.out.println("Usuário " + user.getName() + " adicionado à lista de usuários.");
        } else {
            System.out.println("Usuário " + user.getName() + " já existe na lista de usuários.");
        }
    }

    public void manageUser(User user, String action) {
        switch (action.toLowerCase()) {
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

    public void printUsers() {
        System.out.println("Users: ");
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            System.out.print("Usuario " + (i+1) + ": ");
            System.out.println(u.getName() + " - " + u.getRa());
        }
        System.out.println("=======================\n");
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
