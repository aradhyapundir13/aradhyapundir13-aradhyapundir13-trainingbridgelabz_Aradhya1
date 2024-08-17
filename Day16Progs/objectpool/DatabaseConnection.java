package Day16Progs.objectpool;

public class DatabaseConnection {
    private boolean inUse;
    public DatabaseConnection() {
        inUse = false;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public void connect() {
        System.out.println("Connecting to the database...");
    }
    public void disconnect() {
        System.out.println("Disconnecting from the database...");
    }
}