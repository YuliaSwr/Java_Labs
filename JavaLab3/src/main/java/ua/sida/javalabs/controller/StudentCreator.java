package ua.sida.javalabs.controller;

import ua.sida.javalabs.model.Human;
import ua.sida.javalabs.model.Student;

public class StudentCreator implements ICreator<Student> {

    private final ICreator<Human> humanCreator = new HumanCreator();

    @Override
    public Student createTypicalObject() {
        String randomNumber = String.valueOf((int)(Math.random() * 100000 + 10000));
        return new Student(randomNumber, humanCreator.createTypicalObject());
    }
}
