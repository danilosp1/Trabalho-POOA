package com.model;

import com.enums.CourseType;
import com.enums.GenderType;

public class UserFactory {
    public static User createUser(String type, String name, CourseType course, String ra, GenderType genre, int age, String description) {
        switch (type.toLowerCase()) {
            case "administrador":
                return new Admin(name, course, ra, genre, age, description);
            case "jogador":
                return new Player(name, course, ra, genre, age, description);
            case "mestre":
                return new Master(name, course, ra, genre, age, description);
            default:
                throw new IllegalArgumentException("Tipo de usuário desconhecido: " + type);
        }
    }
}
