package ua.sida.javalabs.util;

/**
 * Набір SQL шаблонів-запитів
 */
public class SQLQueries {

    public static final String SELECT_ALL_STUDENTS = "SELECT * FROM student";

    public static final String INSERT_STUDENT = "INSERT INTO student VALUES (null, ?, ?, ?, ?, ?)";
}
