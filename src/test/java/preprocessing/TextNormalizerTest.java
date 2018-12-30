package preprocessing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextNormalizerTest {

    @Test
    void getWords() {
        assertArrayEquals("Deneme yazısıdır".split(" "),TextNormalizer.getWords("Deneme yazısıdır"));
    }


}