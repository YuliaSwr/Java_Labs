package ua.sida.javalabs;

import ua.sida.javalabs.config.ConfigProperties;
import ua.sida.javalabs.entity.Student;
import ua.sida.javalabs.exception.DBException;
import ua.sida.javalabs.util.SQLQueries;
import ua.sida.javalabs.util.StudentFields;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас-менеджер для роботи напряму з базою даних
 */
public class DBManager {

    /**
     * Метод який створює та повертає з'єднання з
     * базою даних, яка задана в конфігурації
     *
     * @return з'єднання з базою даних
     */
    private Connection getConnection() {
        String CONNECTION_URL = ConfigProperties.getInstance().getProperty("connection.url");
        Connection con = null;
        try {
            con = DriverManager.getConnection(CONNECTION_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * Метод повертає список студентів з бази даних
     *
     * @return список студентів
     * @throws DBException проблема з з'єднанням до бази даних
     */
    public List<Student> findAll() throws DBException {
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(SQLQueries.SELECT_ALL_STUDENTS)) {
            return getStudents(stmt);
        } catch (SQLException e) {
            throw new DBException("Cannot get all students from database", e);
        }
    }

    /**
     * Метод отримує дані з бази даних за допомогою запиту SELECT
     * та конвертує їх в сутності студентів
     *
     * @param stmt підготовлений запит до бази даних
     * @return список отриманих студентів
     * @throws SQLException проблема з базою даних
     */
    private List<Student> getStudents(PreparedStatement stmt) throws SQLException {
        List<Student> students = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Student student = Student.builder()
                    .id(rs.getInt(StudentFields.ID))
                    .firstName(rs.getString(StudentFields.FIRST_NAME))
                    .lastName(rs.getString(StudentFields.LAST_NAME))
                    .middleName(rs.getString(StudentFields.MIDDLE_NAME))
                    .birthDate(Date.valueOf(rs.getString(StudentFields.BIRTH_DATE)))
                    .gradebookNumber(rs.getString(StudentFields.GRADEBOOK_NUMBER))
                    .build();

            students.add(student);
        }
        return students;
    }

    /**
     * Метод надсилає INSERT з новим студентом до бази даних
     *
     * @param student сутність яку треба додати в базу даних
     * @throws DBException проблема з з'єднанням до бази даних
     */
    public void insertStudent(Student student) throws DBException {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = getConnection();
            stmt = con.prepareStatement(SQLQueries.INSERT_STUDENT, Statement.RETURN_GENERATED_KEYS);
            execute(stmt, student);
        } catch (SQLException e) {
            throw new DBException("Cannot insert user", e);
        } finally {
            closeResource(stmt);
            closeResource(con);
        }
    }

    /**
     * Метод виконує заповнення запиту до бази даних
     * та виконує цей запит
     *
     * @param stmt запит до бази даних
     * @param student сутність для нового запису
     * @return флаг чи був додан запис у базу даних
     * @throws SQLException проблема з базою даних
     */
    private boolean execute(PreparedStatement stmt, Student student) throws SQLException {
        int i = 0;
        stmt.setString(++i, student.getFirstName());
        stmt.setString(++i, student.getLastName());
        stmt.setString(++i, student.getMiddleName());
        stmt.setString(++i, student.getBirthDate().toString());
        stmt.setString(++i, student.getGradebookNumber());

        int count = stmt.executeUpdate();
        return count > 0;
    }

    /**
     * Метод закриває отриманий ресурс
     *
     * @param obj ресурс, який треба закрити
     */
    private void closeResource(AutoCloseable obj) {
        if (obj != null) {
            try {
                obj.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
