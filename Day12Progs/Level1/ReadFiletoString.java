package Day12Progs.Level1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ReadFiletoString {
    public static void main(String[] args) {
        String filePath="src/Day12/Level1/file.txt";
        try{
            Path p= Paths.get(filePath);
            List<String> data= Arrays.asList(Files.readString(p));
            System.out.println(data.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}