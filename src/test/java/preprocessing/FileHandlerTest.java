package preprocessing;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @BeforeAll

    @org.junit.jupiter.api.Test
    void readFromFile() throws IOException {
        assertEquals(Arrays.asList("Bu bir denemedir.","Bu bir denemedir."),FileHandler.readFromFile("deneme.txt"));
    }

    @Test
    void writeToFile(){

    }
}