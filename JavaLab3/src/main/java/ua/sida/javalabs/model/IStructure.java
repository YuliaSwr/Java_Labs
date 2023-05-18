package ua.sida.javalabs.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class IStructure {

    /**
     * Назва структури
     */
    protected String name;

    /**
     * Голова структури
     */
    protected Human head;

    /**
     * Метод повертає рядкове представлення
     * з чого складається дана структура
     *
     * @param tab відступ від лівого краю
     * @return рядок зі структурою
     */
    public abstract String getStructure(String tab);
}
