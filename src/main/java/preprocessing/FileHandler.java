package preprocessing;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FileHandler {
    static ArrayList<String> lines;
    BlockingQueue queue;
    BufferedReader fileReader;
    BufferedWriter fileWriter
    public FileHandler(String path) {
        lines = new ArrayList<>();
        queue = new ArrayBlockingQueue(100);
        try {
            fileReader = new BufferedReader(new FileReader(path));
            fileWriter = new BufferedWriter(new FileWriter(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void readFromFile()  {
        try {
            String line;
            while((line = fileReader.readLine()) != null) {
                lines.add(line);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found for reading");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeToFile(String path) {
        String newline = System.getProperty("line.separator");

        for(int i = 0;i< lines.size();i++) {
            try {
                fileWriter.write(lines.get(i)+newline);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
