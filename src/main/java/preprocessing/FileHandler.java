package preprocessing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FileHandler {

    public static ArrayList<String> readFromFile(String filePath) throws IOException {
        ArrayList<String> words = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            words.add(line);
        }
        reader.close();
        return words;
    }

    public static int writeToFile(List<String> lines, String filePath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            String nextLine = System.getProperty("line.separator");
            for(String line : lines) {
                writer.write(line+ nextLine);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
}
