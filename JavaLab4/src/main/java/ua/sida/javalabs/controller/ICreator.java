package ua.sida.javalabs.controller;

public interface ICreator<T> {

    /**
     * Кількість для генератора об'єктів нащадків
     */
    int CREATION_NUMBER = 2;

    /**
     * Метод створює об'єкт класу
     * з випадковим наповненням даних
     *
     * @return об'єкт заданого класу
     */
    T createTypicalObject();

    /**
     * Повертає випадкове число від 1 до 100
     *
     * @return випадкове число
     */
    public static int getRandomNumber() {
        return (int) (Math.random() * 100 + 1);
    }
}
