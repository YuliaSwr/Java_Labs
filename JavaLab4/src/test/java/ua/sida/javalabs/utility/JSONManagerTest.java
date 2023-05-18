package ua.sida.javalabs.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import ua.sida.javalabs.controller.UniversityCreator;
import ua.sida.javalabs.model.University;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JSONManagerTest {

    @Test
    public void testJsonManager() throws IOException {
        UniversityCreator universityCreator = new UniversityCreator();
        University oldUniversity = universityCreator.createTypicalObject();
        JSONManager.writeToFile(oldUniversity, "testJson.json");

        University newUniversity = universityCreator.createTypicalObject();

        assertEquals(oldUniversity, newUniversity);
    }
}
