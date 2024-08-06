package fileprocessor;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileProcessor {
    public void processFiles(List<String> filePaths) {
        for (String filePath : filePaths) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.print(line + " ");
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + filePath);
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<String> files = List.of("src/file_processor/text1.txt", "src/file_processor/text2.txt", "src/file_processor/text3.txt");
        FileProcessor processor = new FileProcessor();
        processor.processFiles(files);
    }
}