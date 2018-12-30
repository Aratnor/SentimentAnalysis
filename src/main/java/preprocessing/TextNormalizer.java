package preprocessing;

import zemberek.morphology.TurkishMorphology;
import zemberek.morphology.analysis.SingleAnalysis;
import zemberek.morphology.analysis.WordAnalysis;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class TextNormalizer {

    public static List<String> shortLongDeletion(List<String> lines, int shortlength, int longlength) {
        List<String> newLines = new ArrayList<>();

        for(String line : lines) {
            String[] words = StringFormatter.getWords(line);
            StringJoiner newLine = new StringJoiner(" ");
            for(String word : words) {
                if(word.length() <= shortlength || word.length() >= longlength) continue;
                newLine.add(word);
            }
            newLines.add(newLine.toString());
        }
        return newLines;
    }

    public static List<String> convertToRoot(List<String> lines) {
        TurkishMorphology morphology = TurkishMorphology.createWithDefaults();
        for(int i = 0;i<lines.size();i++) {
            String [] words = StringFormatter.getWords(lines.get(i));
            String res = "";
            for(int j = 0;j<words.length;j++) {
                WordAnalysis result = morphology.analyze(words[j]);
                if(result.getAnalysisResults().size() >= 1) {
                    SingleAnalysis analysis = result.getAnalysisResults().get(0);
                    if (j == 0) res += analysis.getLemmas().get(0);
                    else res += " " + analysis.getLemmas().get(0);

                }
            }
            System.out.println(res);
            lines.set(i,res);
        }
        return lines;
    }

}
