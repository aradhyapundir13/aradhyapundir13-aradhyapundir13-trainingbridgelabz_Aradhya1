package garbagecollection.customfinalizers;
public class ResourceWithFinalizer implements AutoCloseable {
    public ResourceWithFinalizer() {
        System.out.println("Resource acquired.");
    }
    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Resource cleaned up in finalize.");
        } finally {
            super.finalize();
    }Override
        }
    @Override
    public void close() {
        System.out.println("Resource cleaned up in close.");
    }
    public void doWork() {
        System.out.println("Resource is being used.");
    }
}