package notify;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SendNotify
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test?useSSL=false";

    static final String USER = "root";
    static final String PASS = "123";

    public static void main(String[] args) {
        SendNotify sendNotify = new SendNotify();

        //System.out.println(sendNotify.getQuery());
    }

    private Set<Map<String, String>> getQuery() {
        Connection conn = null;
        Statement stmt = null;
        Set<Map<String, String>> item = new HashSet<Map<String, String>>();

        try{
            Class.forName(JDBC_DRIVER).newInstance();

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name FROM test.test";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Map<String, String> map = new HashMap<String, String>();
                map.put("id", rs.getString("id"));
                map.put("name", rs.getString("name"));

                item.add(map);
            }

            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }

            return item;
        }
    }
}
