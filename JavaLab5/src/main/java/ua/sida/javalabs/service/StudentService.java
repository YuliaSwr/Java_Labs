package ua.sida.javalabs.service;

import ua.sida.javalabs.DBManager;
import ua.sida.javalabs.entity.Student;
import ua.sida.javalabs.exception.DBException;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

/**
 * Класс-сервіс для роботи з даними про студентів
 */
public class StudentService {

    /**
     * Менеджер для роботи з базою даних
     */
    private final DBManager dbManager = new DBManager();

    /**
     * Метод шукає всіх студентів наявних в базі даних
     *
     * @return список всіх студентів
     * @throws DBException помилка з'єднання з базою даних
     */
    public List<Student> getAllStudent() throws DBException {
        return dbManager.findAll();
    }

    /**
     * Метод шукає всіх студентів наявних
     * в базі даних по заданому прізвищу
     *
     * @param lastName прізвище за яким виконується пошук
     * @return список студентів з цим прізвищем
     * @throws DBException помилка з'єднання з базою даних
     */
    public List<Student> getByLastName(String lastName) throws DBException {
        List<Student> students = dbManager.findAll();
        return students.stream()
                .filter(student -> student.getLastName().equals(lastName))
                .toList();
    }

    /**
     * Метод шукає студента у базі
     * по заданому номеру залікової книжки
     *
     * @param gradebookNumber номер залікової книжки для пошуку
     * @return Optional з студентом
     * @throws DBException помилка з'єднання з базою даних
     */
    public Optional<Student> getByGrabebookNumber(String gradebookNumber) throws DBException {
        List<Student> students = dbManager.findAll();
        return students.stream()
                .filter(student -> student.getGradebookNumber().equals(gradebookNumber))
                .findAny();
    }

    /**
     * Метод шукає всіх студентів, які мають дату народження
     * в заданий період (з-по певні дати)
     *
     * @param fromDate початкова дата для пошуку
     * @param toDate   кінцева дата для пошуку
     * @return список студентів
     * @throws DBException помилка з'єднання з базою даних
     */
    public List<Student> getByBirthDate(Date fromDate, Date toDate) throws DBException {
        List<Student> students = dbManager.findAll();
        return students.stream()
                .filter(student -> student.getBirthDate().after(fromDate)
                        && student.getBirthDate().before(toDate))
                .toList();
    }

    /**
     * Метод додає нового студента до бази даних
     *
     * @param student сутність з даними про нового студента
     * @throws DBException помилка з'єднання з базою даних
     */
    public void addStudent(Student student) throws DBException {
        dbManager.insertStudent(student);
    }
}
