package Day18Progs;

import java.sql.*;
import java.io.*;
public class AddingValues
{
    public static void main(String[] args)
    {
        String url="jdbc:postgresql://localhost:5432/inventory_db";
        String userName="postgres";
        String password="root";
        String sqlQuery="insert into productss(product_id,fullname, costs, quantity) values(?,?,?,?)";
        try {
            Connection con=DriverManager.getConnection(url,userName,password);
            PreparedStatement st= con.prepareStatement(sqlQuery);
            st.setInt(1,1111);

            st.setString(2,"shampoo");
            st.setInt(3,300);
            st.setInt(4,4);
            int i=st.executeUpdate();
            System.out.println(i+" rows inserted");
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getString(1));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}