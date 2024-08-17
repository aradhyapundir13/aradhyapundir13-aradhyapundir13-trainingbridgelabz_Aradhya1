package Day12Progs.Level1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFileIntoBuffer {
    public static void main(String[] args) {
        String filePath="src/Day12/Level1/file.txt";
        try(RandomAccessFile reader=new RandomAccessFile(filePath,"r"); FileChannel channel=reader.getChannel()){
            ByteBuffer  buff=ByteBuffer.allocate(1024);
            int noofByteRead=channel.read(buff);
            String fileContent=new String(buff.array(), StandardCharsets.UTF_8);
            System.out.println(fileContent);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}