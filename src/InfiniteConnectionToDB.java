import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;

public class InfiniteConnectionToDB {
    static final String DB_URL = "jdbc:mysql://localhost/test";

    static final String USER = "root";
    static final String PASS = "123";

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            new Thread(() -> {
                Connection conn = null;
                Statement stmt = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");

                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    System.out.println("Connected database successfully...");

                    System.out.println("Creating statement...");
                    stmt = conn.createStatement();

                    String sql = "SELECT PersonId FROM Persons";
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        int id = rs.getInt("PersonId");

                        System.out.print("ID: " + id);
//                        Thread.sleep(1000);
                    }
                    //TODO
                    System.out.println(conn);
//                    rs.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            Thread.sleep(50);
        }
    }
}
