package com.model;
import com.enums.CourseType;
import com.enums.GenderType;

import java.util.UUID;

public abstract class User {
    private UUID id;
    private String name;
    private boolean active;
    private CourseType course;
    private String ra;
    private GenderType genre;
    private int age;
    private String description;

    public User(String name, CourseType course, String ra, GenderType genre, int age, String description) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.course = course;
        this.ra = ra;
        this.genre = genre;
        this.age = age;
        this.description = description;
        this.active = true;
    }

    public void changeAccount(String newName, CourseType newCourse, GenderType newGenre, int newAge, String newDescription){
        if (!this.isActive()) {
            System.out.println("Não é possível alterar a conta de um usuário inativo.");
            return;
        }

        if (newName != null && !newName.isEmpty()) {
            this.setName(newName);
        }
        if (newCourse != null) {
            this.setCourse(newCourse);
        }
        if (newGenre != null) {
            this.setGenre(newGenre);
        }
        if (newAge > 0) {
            this.setAge(newAge);
        }
        if (newDescription != null && !newDescription.isEmpty()) {
            this.setDescription(newDescription);
        }
        System.out.println("Conta de " + this.getName() + " alterada com sucesso.");
    }

    public void requestNewSystem(String date, String name, Admin admin){
        if(!this.isActive()){
            NewSystemRequest request = new NewSystemRequest(date, name);
            admin.setNewSystemRequest(request);
            System.out.println(this.getName() + " solicitou um novo sistema RPG: " + name);
        } else {
            System.out.println(this.getName() + " não é um usuário ativo.");
        }
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CourseType getCourse() {
        return course;
    }

    public void setCourse(CourseType course) {
        this.course = course;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public GenderType getGenre() {
        return genre;
    }

    public void setGenre(GenderType genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
}
