package Day11Progs.writeinput.copyfilecontent;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String source = "src/Day11/copyfilecontent/source.txt";
        String destination = "src/Day11/copyfilecontent/destination.txt";

        copyContent(source, destination);
    }

    public static void copyContent(String source, String destination) {
        try (
                BufferedReader br = new BufferedReader(new FileReader(source));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destination));
        ) {
            String line;
            while((line = br.readLine()) != null) {
                writer.write(line);
            }
            System.out.println("Content copied successfully");

        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    }
}