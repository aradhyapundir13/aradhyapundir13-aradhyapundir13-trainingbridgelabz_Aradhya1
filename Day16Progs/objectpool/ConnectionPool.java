package Day16Progs.objectpool;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private List<DatabaseConnection> availableConnections;
    private List<DatabaseConnection> inUseConnections;
    private int maxSize;

    public ConnectionPool(int maxSize) {
        this.maxSize = maxSize;
        availableConnections = new ArrayList<>();
        inUseConnections = new ArrayList<>();

        for(int i = 0; i < maxSize; i++) {
            availableConnections.add(new DatabaseConnection());
        }
    }

    public synchronized DatabaseConnection borrowConnection() {
        if(availableConnections.isEmpty() && inUseConnections.size() < maxSize) {
            DatabaseConnection connection = new DatabaseConnection();
            connection.setInUse(true);
            inUseConnections.add(connection);
            return connection;
        } else if (!availableConnections.isEmpty()) {
            DatabaseConnection connection = availableConnections.remove(availableConnections.size() - 1);
            connection.setInUse(true);
            inUseConnections.add(connection);
            return connection;
        } else {
            System.out.println("No available connections. Please wait...");
            return null;
        }
    }

    public synchronized void returnConnection(DatabaseConnection connection) {
        if(connection != null) {
            connection.setInUse(false);
            inUseConnections.remove(connection);
            availableConnections.add(connection);
        }
    }
}