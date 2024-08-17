package Day11Progs.writeinput.reversecontent;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Day11/reversecontent/input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Day11/reversecontent/reversed.txt"));

        try {
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null) {
                sb.append(line);
            }
            sb.reverse();
            writer.write(sb.toString());
            System.out.println("Reversed content written successfully");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            writer.close();
            br.close();
        }
    }
}