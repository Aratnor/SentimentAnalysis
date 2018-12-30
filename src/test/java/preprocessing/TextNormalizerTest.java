package preprocessing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TextNormalizerTest {

    @Test
    void shortLongDeletion() {
        String example = "Güzel aksiyon sahneleri olmasına rağmen hikayesi o kadar güzel değildi";
        String example2 = "Çok beğenmedim";
        assertEquals(Arrays.asList("Güzel aksiyon sahneleri olmasına rağmen hikayesi kadar güzel değildi","Çok beğenmedim"),TextNormalizer.shortLongDeletion(Arrays.asList(example,example2),1,12));
    }

    @Test
    void convertToRoot() {
        String example = "Güzel aksiyon sahneleri olmasına rağmen hikayesi o kadar güzel değildi";
        String example2 = "Çok beğenmedim";
        assertEquals(Arrays.asList("güzel aksiyon sahne ol rağmen hikaye o kadar güzel değil","çok beğen"),TextNormalizer.convertToRoot(Arrays.asList(example,example2)));
    }

}