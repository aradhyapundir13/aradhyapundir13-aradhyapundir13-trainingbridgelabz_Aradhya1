package Day18Progs;

import java.sql.*;
import java.io.*;
public class SimpleQuery {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/company_db";
        String userName = "postgres";
        String password = "root";
        String sqlQuery = "select * from employee";
        Connection con;

        {
            try {
                con = DriverManager.getConnection(url, userName, password);
                PreparedStatement st = con.prepareStatement(sqlQuery);
                ResultSet rs = st.executeQuery();
                int cnt = st.getMetaData().getColumnCount();
                while (rs.next()) {
                    for (int i = 1; i <= cnt; i++) {
                        System.out.print(rs.getString(i) + "  ");
                    }
                    System.out.println();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}