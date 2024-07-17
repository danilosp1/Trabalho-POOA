package org.example;

import com.enums.CharacterClassType;
import com.enums.CourseType;
import com.enums.GenderType;
import com.enums.RaceType;
import com.model.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Jose", null, CourseType.COMPUTER_SCIENCE, "999999", GenderType.HOMEM, 21, "...");
        p1.createCharacter("ZION", 10, GenderType.HOMEM, 20, CharacterClassType.GUERREIRO, RaceType.HUMANO, null, "...");
        p1.createCharacter("Asterius", 10, GenderType.HOMEM, 34, CharacterClassType.MAGO, RaceType.ELFO, null, "...");
        p1.createCharacter("Legolas", 10, GenderType.HOMEM, 200, CharacterClassType.GUERREIRO, RaceType.ELFO, null, "...");
        p1.createCharacter("Basneria", 10, GenderType.MULHER, 120, CharacterClassType.CURANDEIRO, RaceType.ELFO, null, "...");

        System.out.println();
        p1.printSheetList();

        System.out.println();
        p1.deleteCharacter();

        System.out.println();
        p1.printSheetList();
    }
}