package Day12Progs.Level1.directoryfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ListFilesinDirectory {
    public static void main(String[] args) {
        String dPath="src/Day12/Level1/directoryfile";
        try{
            Path p= Paths.get(dPath);
            if(Files.exists(p)){
                System.out.println("Directory already present");
            }
            else{
                Path done=Files.createDirectories(p);
                System.out.println("Created Directory at : "+done.toString());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try{
            createFileIfNotExists("src/Day12/Level1/directoryfile/file1.txt");
            createFileIfNotExists("src/Day12/Level1/directoryfile/file2.txt");
            createFileIfNotExists("src/Day12/Level1/directoryfile/file3.txt");
            createFileIfNotExists("src/Day12/Level1/directoryfile/file4.txt");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try{
            Path dir=Paths.get(dPath);
            try(Stream<Path> stream=Files.list(dir)){
                stream.filter(Files::isRegularFile).forEach(System.out::println);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void createFileIfNotExists(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
    }
}