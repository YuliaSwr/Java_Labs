package ua.sida.javalabs.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Університет
 */
@Getter
@Setter
@ToString
@SuperBuilder
public class University extends IStructure {

    /**
     * Факультети які належать до даного студента
     */
    private List<Faculty> faculties;

    @Override
    public String getStructure(String tab) {
        StringBuilder structure = new StringBuilder();
        structure.append(name);
        structure.append(" (Head - ").append(head.getFullName()).append(")");
        structure.append("\n\n");

        for (Faculty faculty : faculties) {
            structure.append(faculty.getStructure(tab + tab));
            structure.append("\n");
        }

        return structure.toString();
    }
}
