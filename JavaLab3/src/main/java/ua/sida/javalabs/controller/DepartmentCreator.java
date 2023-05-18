package ua.sida.javalabs.controller;

import ua.sida.javalabs.model.Department;
import ua.sida.javalabs.model.Group;
import ua.sida.javalabs.model.Human;

import java.util.ArrayList;
import java.util.List;

public class DepartmentCreator implements ICreator<Department> {

    private final ICreator<Group> groupCreator = new GroupCreator();
    private final ICreator<Human> humanCreator = new HumanCreator();

    @Override
    public Department createTypicalObject() {
        List<Group> groups = new ArrayList<>();

        for (int i = 0; i < CREATION_NUMBER; i++) {
            groups.add(groupCreator.createTypicalObject());
        }

        return Department.builder()
                .name("Department_" + ICreator.getRandomNumber())
                .head(humanCreator.createTypicalObject())
                .groups(groups)
                .build();
    }
}
