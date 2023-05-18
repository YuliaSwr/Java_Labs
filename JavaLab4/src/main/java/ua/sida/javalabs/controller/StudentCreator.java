package ua.sida.javalabs.controller;

import ua.sida.javalabs.model.Human;
import ua.sida.javalabs.model.Student;

public class StudentCreator implements ICreator<Student> {

    private final ICreator<Human> humanCreator = new HumanCreator();

    @Override
    public Student createTypicalObject() {
        String gradebookNumber = "123456";
        return new Student(gradebookNumber, humanCreator.createTypicalObject());
    }
}
