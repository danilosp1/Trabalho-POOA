package com.model;
import com.enums.CourseType;
import com.enums.GenderType;

import java.sql.Blob;
import java.util.UUID;

public abstract class User {
    private UUID id;
    private String name;
    private Blob picture;
    private CourseType course;
    private String ra;
    private GenderType genre;
    private int age;
    private String description;

    public User(String name, Blob picture, CourseType course, String ra, GenderType genre, int age, String description) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.picture = picture;
        this.course = course;
        this.ra = ra;
        this.genre = genre;
        this.age = age;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void changeAccount(){

    }

    public void deleteAccount(){

    }

    public void requestNewSystem(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
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
}
