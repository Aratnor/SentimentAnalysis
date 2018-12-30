import preprocessing.TextNormalizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String [] args) {

        ArrayList<String> stopWords = new ArrayList<String>() {{
            //"bu" "ama", "de", "o", "gibi", "bir", "ve", "artık", "ki", "ayrıca", "ile", "çünkü", "birşey", "şey"
            add("bu");
            add("ama");
            add("de");
            add("o");
            add("gibi");
            add("bir");
            add("ve");
            add("artık");
            add("ki");
            add("ayrıca");
            add("ile");
            add("çünkü");
            add("birşey");
            add("şey");
            add("kadar");
        }};

        String path ="negative.txt";
        List<String> lines = new ArrayList<>();
        try {
            lines = TextNormalizer.textNormalization(path);
            TextNormalizer.convertToRoot(lines);
            TextNormalizer.erasePunctuation(lines);
            TextNormalizer.removeStopWords(lines,stopWords);
            TextNormalizer.shortLongDeletion(lines,2,12);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String line : lines) {
            System.out.println(line);
        }
    }
}
