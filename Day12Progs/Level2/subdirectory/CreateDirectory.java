package Day12Progs.Level2.subdirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CreateDirectory {
    public static void main(String[] args) {
        Path baseDir = Paths.get("base_directory");
        List<String> directoryStructure = List.of("dir1", "dir1/subdir1", "dir1/subdir2", "dir2", "dir2/subdir1", "dir2/subdir1/subsubdir1");

        for (String dir : directoryStructure) {
            createDirectory(baseDir.resolve(dir));
        }
    }

    private static void createDirectory(Path path) {
        try {
            Files.createDirectories(path);
            System.out.println("Directory created: " + path);
        } catch (IOException e) {
            System.out.println("Error creating directory: " + path + " - " + e.getMessage());
        }
    }
}