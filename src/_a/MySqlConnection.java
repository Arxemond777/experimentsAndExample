package _a;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class MySqlConnection {
    public static void main(String args[]) throws InterruptedException {


        while (true) {
            new Thread(() -> {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/test?useSSL=false", "root", "123");
//here sonoo is database name, root is username and password
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from documents");
                    while (rs.next())
                        System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }).start();
            Thread.sleep(3000);
        }

    }
}