package preprocessing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {
    public static ArrayList<String> readFromFile(String path) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader fileReader;
        try {
            fileReader = new BufferedReader(new FileReader(path));
            String line;
            while((line = fileReader.readLine()) != null) {
                lines.add(line);
            }
            fileReader.close();
            return lines;
        } catch (FileNotFoundException e) {
            System.out.println("File not found for reading");
            throw e;
        }
    }
}
