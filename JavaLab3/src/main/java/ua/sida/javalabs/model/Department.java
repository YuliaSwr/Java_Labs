package ua.sida.javalabs.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
public class Department extends IStructure {

    /**
     * Групи які належать до даної кафедри
     */
    private List<Group> groups;

    @Override
    public String getStructure(String tab) {
        StringBuilder structure = new StringBuilder();
        structure.append(tab).append("- ").append(name);
        structure.append(" (Head - ").append(head.getFullName()).append(")");
        structure.append("\n");

        for (Group group : groups) {
            structure.append(group.getStructure(tab + tab));
        }

        return structure.toString();
    }
}
