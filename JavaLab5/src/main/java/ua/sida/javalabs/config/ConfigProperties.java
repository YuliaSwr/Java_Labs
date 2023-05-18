package ua.sida.javalabs.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Клас для роботи з конфігурацією додатку
 */
public class ConfigProperties {
    private static final Properties prop = new Properties();

    private static ConfigProperties INSTANCE;

    /**
     * Конструктор який зчитує параметри задані
     * в відповідному файлі app.properties
     */
    private ConfigProperties() {
        try (InputStream in = new FileInputStream("app.properties")) {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigProperties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConfigProperties();
        }
        return INSTANCE;
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }
}
