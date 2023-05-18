package ua.sida.javalabs.controller;

import ua.sida.javalabs.model.Group;
import ua.sida.javalabs.model.Human;
import ua.sida.javalabs.model.Student;

import java.util.ArrayList;
import java.util.List;

public class GroupCreator implements ICreator<Group> {

    private final ICreator<Student> studentCreator = new StudentCreator();
    private final ICreator<Human> humanCreator = new HumanCreator();

    @Override
    public Group createTypicalObject() {
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < CREATION_NUMBER; i++) {
            students.add(studentCreator.createTypicalObject());
        }

        return Group.builder()
                .name("GroupName")
                .head(humanCreator.createTypicalObject())
                .students(students)
                .build();
    }
}
