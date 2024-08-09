package garbagecollection;
import java.util.ArrayList;
import java.util.List;

public class MemoryUsage {
    public static void main(String[] args) {
        List<LargeData> largeDataList = new ArrayList<>();

        printMemoryUsage("Initial");

        for(int i = 0; i < 1000; i++) {
            largeDataList.add(new LargeData());
        }

        printMemoryUsage("After adding objects");
        largeDataList.clear();

        System.gc();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printMemoryUsage("After clearing list and GC");
    }

    private static void printMemoryUsage(String phase) {
        Runtime runtime = Runtime.getRuntime();
        long usedMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory " + phase + " :" + usedMemory / (1024 * 1024) + "MB");
    }
}

class LargeData {
    private byte[] data = new byte[1024 * 1024];
}