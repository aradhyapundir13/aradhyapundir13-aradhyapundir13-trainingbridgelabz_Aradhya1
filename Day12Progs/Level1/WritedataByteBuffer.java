package Day12Progs.Level1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class WritedataByteBuffer {
    public static void main(String[] args) {
        String filePath="src/Day12/Level1/file.txt";
        try(RandomAccessFile reader=new RandomAccessFile(filePath,"rw"); FileChannel channel=reader.getChannel()){
            ByteBuffer buff=ByteBuffer.wrap("Hello and welcome".getBytes(StandardCharsets.UTF_8));
            channel.write(buff);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}