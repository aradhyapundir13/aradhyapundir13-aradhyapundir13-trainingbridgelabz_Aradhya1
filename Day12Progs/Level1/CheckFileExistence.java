package Day12Progs.Level1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckFileExistence {
    public static void main(String[] args) {
        String filePath="src/Day12/Level1/file.txt";
        Path p= Paths.get(filePath);
        if(Files.exists(p)){
            System.out.println("File exists");
        }
        else{
            System.out.println("File does not exist");
        }
    }
}