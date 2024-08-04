import java.io.IOException;
import java.util.*;
public class ExceptionChaining
{
    public static void main(String[] args) {
        try {
            readFile();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e);
            System.out.println("Original cause: " + e.getCause());
        }
    }

    public static void readFile() throws Exception {
        try {
            throw new IOException("Error reading file");
        } catch (IOException e) {
            throw new Exception("Exception occurred in readFile method", e);
        }
    }
}