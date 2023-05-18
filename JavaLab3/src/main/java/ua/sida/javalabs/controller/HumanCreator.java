package ua.sida.javalabs.controller;

import ua.sida.javalabs.model.Human;
import ua.sida.javalabs.model.Sex;

public class HumanCreator implements ICreator<Human> {

    @Override
    public Human createTypicalObject() {
        int randomNumber = ICreator.getRandomNumber();

        return Human.builder()
                .firstName("FirstName_" + randomNumber)
                .lastName("LastName_" + randomNumber)
                .middleName("MiddleName_" + randomNumber)
                .gender(randomNumber / 2 == 0 ? Sex.FEMALE : Sex.MALE)
                .build();
    }
}
