package com.interfaces;

import com.enums.CourseType;
import com.enums.GenderType;

public interface UserInterface {
    void changeAccount(String newName, CourseType newCourse, GenderType newGenre, int newAge, String newDescription);
}
