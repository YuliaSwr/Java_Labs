package ua.sida.javalabs.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
public class Faculty extends IStructure {

    /**
     * Кафедри які належать до даного факультету
     */
    private List<Department> departments;

    @Override
    public String getStructure(String tab) {
        StringBuilder structure = new StringBuilder();
        structure.append(tab).append("- ").append(name);
        structure.append(" (Head - ").append(head.getFullName()).append(")");
        structure.append("\n");

        for (Department department : departments) {
            structure.append(department.getStructure(tab + tab));
        }

        return structure.toString();
    }
}
