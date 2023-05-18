package ua.sida.javalabs.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Human {
    /**
     * Ім'я людини
     */
    private String firstName;

    /**
     * Прізвище людини
     */
    private String lastName;

    /**
     * По-батькові людини
     */
    private String middleName;

    /**
     * Стать людини
     */
    private Sex gender;

    /**
     * Метод повертає повне ім'я людини (ім'я + прізвище)
     *
     * @return повне ім'я
     */
    public String getFullName() {
        return lastName + " " + firstName;
    }
}
