package Day12Progs.Level1.movefile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MoveorRename {
    public static void main(String[] args) {
        String filePath1="src/Day12/Level1/movefile/example1.txt";
        String filePath2="src/Day12/Level1/movefile/example.txt";
        try{
            Path input= Paths.get(filePath1);
            Path output=Paths.get(filePath2);
            Files.move(input,output, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}