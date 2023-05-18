package ua.sida.javalabs.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
public class Group extends IStructure {

    /**
     * Студенти які належать до даної групи
     */
    private List<Student> students;

    @Override
    public String getStructure(String tab) {
        StringBuilder structure = new StringBuilder();
        structure.append(tab).append("- ").append(name);
        structure.append(" (Head - ").append(head.getFullName()).append(")");
        structure.append("\n");

        for (Student student : students) {
            structure.append(tab).append("  ").append("- ");
            structure.append(student.getFullName()).append(" : ").append(student.getGradeBookNumber());
            structure.append("\n");
        }

        return structure.toString();
    }
}
