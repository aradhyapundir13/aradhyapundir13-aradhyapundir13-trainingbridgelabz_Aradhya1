package Day12Progs.Level1.readfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ReadLinebyLine {
    public static void main(String[] args) {
        String filePath="src/Day12/Level1/readfile/file.txt";
        try(Stream<String> lines = Files.lines(Path.of(filePath))){
            lines.forEach(System.out :: println);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}