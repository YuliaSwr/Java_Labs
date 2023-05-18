package ua.sida.javalabs.controller;

import ua.sida.javalabs.model.Human;
import ua.sida.javalabs.model.Sex;

public class HumanCreator implements ICreator<Human> {

    @Override
    public Human createTypicalObject() {
        return Human.builder()
                .firstName("FirstName")
                .lastName("LastName")
                .middleName("MiddleName")
                .gender(Sex.FEMALE)
                .build();
    }
}
