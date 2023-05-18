package ua.sida.javalabs;

import ua.sida.javalabs.controller.UniversityCreator;
import ua.sida.javalabs.model.IStructure;
import ua.sida.javalabs.model.University;
import ua.sida.javalabs.utility.JSONManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("\nWelcome to App for Java Lab 4 developed by Yulia Sida 121-20-2");
        System.out.println("This App creates a structure for university represented by JSON.\n" +
                "Below you can see it:\n");

        UniversityCreator universityCreator = new UniversityCreator();

        // створюємо університет та записуємо у файл
        University university = universityCreator.createTypicalObject();
        JSONManager.writeToFile(university, "test.json");

        // зчитуємо університет з файлу
        IStructure uniFromFile = JSONManager.readFromFile("test.json", University.class);

        // виводимо у консоль структуру університету
        System.out.println(JSONManager.toPrettyLook(uniFromFile));
    }
}
