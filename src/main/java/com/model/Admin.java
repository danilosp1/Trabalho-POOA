package com.model;

import com.enums.CourseType;
import com.enums.GenderType;

import java.sql.Blob;

public class Admin extends User{
    private NewSystemRequest[] newSystems;

    public Admin(String name, Blob picture, CourseType course, String ra, GenderType genre, int age, String description) {
        super(name, picture, course, ra, genre, age, description);
        this.newSystems = new NewSystemRequest[0];
    }

    public void createSystem(){}

    public void deleteSystem(){}

    public void changeUser(){}

    public NewSystemRequest[] getNewSystemRequest() {
        return newSystems;
    }
}
