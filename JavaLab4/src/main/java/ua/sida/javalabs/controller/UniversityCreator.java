package ua.sida.javalabs.controller;

import ua.sida.javalabs.model.Faculty;
import ua.sida.javalabs.model.Human;
import ua.sida.javalabs.model.University;

import java.util.ArrayList;
import java.util.List;

public class UniversityCreator implements ICreator<University> {

    private final ICreator<Faculty> facultyCreator = new FacultyCreator();
    private final ICreator<Human> humanCreator = new HumanCreator();

    @Override
    public University createTypicalObject() {
        List<Faculty> faculties = new ArrayList<>();

        for (int i = 0; i < CREATION_NUMBER; i++) {
            faculties.add(facultyCreator.createTypicalObject());
        }

        return University.builder()
                .name("UniversityName")
                .head(humanCreator.createTypicalObject())
                .faculties(faculties)
                .build();
    }
}
