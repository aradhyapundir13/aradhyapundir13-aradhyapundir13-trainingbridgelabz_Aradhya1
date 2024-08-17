package Day11Progs.writeinput.aggregationreportsdata;

import java.io.*;
import java.util.HashMap;

public class Aggregation {
    public static void main(String[] args) {
        HashMap<Integer, Integer> mp=new HashMap<>();
        String inp="src/Day11/AggregationReportsData/log.txt";
        String oup="src/Day11/AggregationReportsData/log_summary.txt";
        try(BufferedReader reader=new BufferedReader(new FileReader(inp));
            BufferedWriter writer=new BufferedWriter(new FileWriter(oup))){
            String line;
            while ((line=reader.readLine())!=null){
                String []data=line.split(",");
                int key = Integer.parseInt(data[1]);
                mp.put(key, mp.getOrDefault(key, 0) + 1);
            }
            writer.write(mp.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}