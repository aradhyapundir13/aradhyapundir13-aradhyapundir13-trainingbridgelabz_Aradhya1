package garbagecollection.customfinalizers;
public class TryWithResourcesDemo {

    public static void main(String[] args) {
        System.out.println("Using try-with-resources:");
        tryWithResourcesExample();

        System.out.println("\nUsing finalizer:");
        finalizerExample();
        System.gc();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void tryWithResourcesExample() {
        try (ResourceWithFinalizer resource = new ResourceWithFinalizer()) {
            resource.doWork();
        }
    }
    private static void finalizerExample() {
        ResourceWithFinalizer resource = new ResourceWithFinalizer();
        resource.doWork();
        resource = null;
    }
}