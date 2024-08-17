package Day16Progs.objectpool;

import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool(3);
        DatabaseConnection conn1 = pool.borrowConnection();
        if(conn1 != null) {
            conn1.connect();
        }
        DatabaseConnection conn2 = pool.borrowConnection();
        if(conn2 != null) {
            conn2.connect();
        }
        DatabaseConnection conn3 = pool.borrowConnection();
        if(conn3 != null) {
            conn3.connect();
        }
        DatabaseConnection conn4 = pool.borrowConnection();
        if(conn4 != null) {
            conn4.connect();
        } else {
            System.out.println("Failed to borrow a fourth connection");
        }

        pool.returnConnection(conn1);
        conn1.disconnect();

        DatabaseConnection conn5 = pool.borrowConnection();
        if(conn5 != null) {
            conn5.connect();
        }
    }
}