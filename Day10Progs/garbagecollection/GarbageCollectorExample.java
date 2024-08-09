package garbagecollection;
public class GarbageCollectorExample {
    public GarbageCollectorExample() {
        System.out.println("GCExample instance created");
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("GCExample is being garbage collected");
        } finally {
            super.finalize();
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            GarbageCollectorExample example = new GarbageCollectorExample();
        }
        System.gc();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}