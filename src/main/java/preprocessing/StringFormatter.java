package preprocessing;

import java.util.ArrayList;
import java.util.List;

public class StringFormatter {

    public static String[] getWords(String line) {
        return line.split(" ");
    }

    public static double getGivenWordCount(List<String> lines,String term) {
        double total = 0.0;
        for(String line:lines) {
            String[] words =getWords(line);
            for(String word : words) {
                if(term.equals(word)) total++;
            }
        }
        return total;
    }

    public static double getGivenWordAbsenceCount(List<String> lines,String term) {
        double total = 0.0;
        for(String line:lines) {
            String[] words =getWords(line);
            for(String word : words) {
                if(!term.equals(word)) total++;
            }
        }
        return total;
    }

    public static List<String> toLowerCase(List<String> lines) {
        for(int i = 0;i<lines.size();i++) {
            lines.set(i,lines.get(i).toLowerCase());
        }
        return lines;
    }

    public static double getTotalWords(List<String> lines) {
        int total = 0;
        for(String line : lines) {
            total += getWords(line).length;

        }
        return total;
    }

}
