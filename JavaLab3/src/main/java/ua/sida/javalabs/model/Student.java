package ua.sida.javalabs.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends Human {

    /**
     * Номер залікової книжки студента
     */
    private String gradeBookNumber;

    public Student(String gradeBookNumber, Human human) {
        super(human.getFirstName(), human.getLastName(), human.getMiddleName(), human.getGender());
        this.gradeBookNumber = gradeBookNumber;
    }
}
