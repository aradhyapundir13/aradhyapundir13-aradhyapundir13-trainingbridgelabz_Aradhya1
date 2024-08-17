package Day18Progs;

import java.sql.*;
import java.io.*;
public class BasicConnection
{
    public static void main(String[] args)
    {
        String url="jdbc:postgresql://localhost:5432/test_db";
        String userName="postgres";
        String password="root";
        try {
            Connection con=DriverManager.getConnection(url,userName,password);
            System.out.println("connection established");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}