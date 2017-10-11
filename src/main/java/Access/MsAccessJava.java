package Access;


import java.sql.*;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Mojo<br>
 * Date: 08 Feb 09<br>
 * Time: 22:30:08<p>
 */
public class MsAccessJava {
    private static String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";
    private static String url = "jdbc:odbc:JavaMsAccess";
    public static void main(String[] args) throws Exception{
        String sql ="SELECT * from tblCustomer";
        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connection Established..");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                System.out.println("+------------- Detail Customer ----------------------+");
                System.out.println("Customer ID : "+ rs.getInt(1));
                System.out.println("Customer Name : "+ rs.getString(2));
                System.out.println("Customer Address : "+ rs.getString(3));
                System.out.println("Customer Phone : "+ rs.getString(4));
                System.out.println("+----------------------------------------------------+");
                System.out.println("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}