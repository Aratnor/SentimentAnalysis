package preprocessing;

import org.antlr.v4.runtime.Token;
import zemberek.morphology.TurkishMorphology;
import zemberek.morphology.analysis.SingleAnalysis;
import zemberek.morphology.analysis.WordAnalysis;
import zemberek.normalization.TurkishSentenceNormalizer;
import zemberek.tokenization.TurkishTokenizer;
import zemberek.tokenization.antlr.TurkishLexer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public static List<String> textNormalization(String getPath) throws IOException {
        Path lookupRoot = Paths.get("C:\\Users\\Tuna\\Desktop\\Pattern Recognation\\drive-download-20181222T140153Z-001\\normalization");
        Path lmFile = Paths.get("C:\\Users\\Tuna\\Desktop\\Pattern Recognation\\drive-download-20181222T140153Z-001\\lm\\lm.2gram.slm");
        TurkishMorphology morphology = TurkishMorphology.createWithDefaults();
        TurkishSentenceNormalizer normalizer = new
                TurkishSentenceNormalizer(morphology, lookupRoot, lmFile);
        String path = getPath;
        ArrayList<String> lines = FileHandler.readFromFile(path);
        for(String s : lines) {
            normalizer.normalize(s);
        }
        return lines;
    }

    public static List<String> erasePunctuation(List<String> list) {
        TurkishTokenizer tokenizer = TurkishTokenizer.DEFAULT;
        List<Token> tokens = null;
        for(int i=0; i<list.size(); i++) {
            tokens = tokenizer.tokenize(list.get(i));

            String newresult = "";
            for (int j=0; j<tokens.size(); j++) {
                if(TurkishLexer.VOCABULARY.getDisplayName(tokens.get(j).getType()).equals("Punctuation")) {
                    continue;
                }
                if(j==0)
                    newresult += tokens.get(j).getText();
                else
                    newresult += " " + tokens.get(j).getText();
            }
            list.set(i, newresult);

        }


        return list;
    }

    public static List<String> removeStopWords(List<String> list, ArrayList<String> stopWords) {
        TurkishTokenizer tokenizer = TurkishTokenizer.DEFAULT;
        List<Token> tokens = null;
        for (int i = 0; i < list.size(); i++) {
            tokens = tokenizer.tokenize(list.get(i));
            List<Token> tempTokens = tokens;
            String newresult = "";
            for (String stopWord : stopWords) {
                for (int j = 0; j < tempTokens.size(); j++) {
                    if (tempTokens.get(j).getText().equals(stopWord)) {
                        tokens.remove(j);
                    }
                }
            }
            for(int j=0; j<tokens.size(); j++) {
                if(j==0)
                    newresult += tokens.get(j).getText();
                else
                    newresult += " " + tokens.get(j).getText();
            }
            list.set(i, newresult);

        }
        return list;
    }
}
