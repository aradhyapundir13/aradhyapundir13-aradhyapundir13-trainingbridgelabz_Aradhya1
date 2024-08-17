package Day12Progs.Level1.copyfile;

import java.io.IOException;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("src/Day12/copyfile/source.txt");
        Path destPath = Paths.get("src/Day12/copyfile/destination.txt");
        try {
            Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully");
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}