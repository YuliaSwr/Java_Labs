package ua.sida.javalabs;

import ua.sida.javalabs.controller.UniversityCreator;
import ua.sida.javalabs.model.University;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nWelcome to App for Java Lab 3 developed by Yulia Sida 121-20-2");
        System.out.println("This App creates a structure for university with random names.\n" +
                "Below you can see it:\n");

        UniversityCreator universityCreator = new UniversityCreator();
        University university = universityCreator.createTypicalObject();
        System.out.println(university.getStructure("  "));
    }
}
