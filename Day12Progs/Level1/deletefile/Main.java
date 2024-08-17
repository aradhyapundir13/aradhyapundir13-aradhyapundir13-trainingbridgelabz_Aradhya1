package Day12Progs.Level1.deletefile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("src/Day12/deletefile/file.txt");
        System.out.println("File deleted successfully");
        try {
            Files.delete(filePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}