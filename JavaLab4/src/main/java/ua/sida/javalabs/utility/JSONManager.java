package ua.sida.javalabs.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.sida.javalabs.model.IStructure;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONManager {

    /**
     * Метод записує об'єкт у вигляді json у файл
     *
     * @param structure об'єкт який записуємо
     * @param filePath  шлях до файлу в який записувати
     * @throws IOException помилка з записом до файлу
     */
    public static void writeToFile(IStructure structure, String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(toPrettyLook(structure));
        fileWriter.close();
    }

    /**
     * Метод зчитує об'єкт у вигляді json з файлу
     *
     * @param filePath файл для зчитування
     * @param type     клас об'єкту записаного в у файлі
     * @param <T>      тип об'єкту
     * @return об'єкт отриманий з файлу
     * @throws IOException помилка зчитування з файлу
     */
    public static <T extends IStructure> IStructure readFromFile(String filePath, Class<T> type) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileReader fileReader = new FileReader(filePath);
        return gson.fromJson(fileReader, type);
    }

    /**
     * Метод який повертає json з об'єкту у гарному вигляді
     *
     * @param obj об'єкт для перетворення
     * @return json у вигляді строки
     */
    public static String toPrettyLook(IStructure obj) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(obj);
    }
}

