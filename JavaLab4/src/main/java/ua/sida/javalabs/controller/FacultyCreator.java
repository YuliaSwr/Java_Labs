package ua.sida.javalabs.controller;

import ua.sida.javalabs.model.Department;
import ua.sida.javalabs.model.Faculty;
import ua.sida.javalabs.model.Human;

import java.util.ArrayList;
import java.util.List;

public class FacultyCreator implements ICreator<Faculty> {

    private final ICreator<Department> departmentCreator = new DepartmentCreator();
    private final ICreator<Human> humanCreator = new HumanCreator();

    @Override
    public Faculty createTypicalObject() {
        List<Department> departments = new ArrayList<>();

        for (int i = 0; i < CREATION_NUMBER; i++) {
            departments.add(departmentCreator.createTypicalObject());
        }

        return Faculty.builder()
                .name("FacultyName")
                .head(humanCreator.createTypicalObject())
                .departments(departments)
                .build();
    }
}
