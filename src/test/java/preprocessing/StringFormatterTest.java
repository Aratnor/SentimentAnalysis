package preprocessing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringFormatterTest {

    @Test
    void getWords() {
        assertArrayEquals("Deneme yazısıdır".split(" "),StringFormatter.getWords("Deneme yazısıdır"));
    }

    @Test
    void getGivenWordCount() {
        String example = "Bu harika bir film";
        String example2 = " Bu cok berbat bir film";
        assertEquals(2.0,StringFormatter.getGivenWordCount(Arrays.asList(example,example2),"film"));
    }

    @Test
    void getGivenWordAbsenceCount() {
        String example = "Bu harika bir film";
        String example2 = "Bu cok berbat bir film";
        assertEquals(7.0,StringFormatter.getGivenWordAbsenceCount(Arrays.asList(example,example2),"film"));
    }

    @Test
    void toLowerCase() {
        String example = "Bu haRika bir film";
        String example2 = "Bu COk berbat bir film";
        assertEquals(Arrays.asList(example.toLowerCase(),example2.toLowerCase()),StringFormatter.toLowerCase(Arrays.asList(example,example2)));
    }

    @Test
    void getTotalWords() {
        String example = "Bu harika bir film";
        String example2 = "Bu cok berbat bir film";
        assertEquals(9.0,StringFormatter.getTotalWords(Arrays.asList(example,example2)));
    }
}