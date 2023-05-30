package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getMySQlConnection() throws Exception {

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test"
                    ,"root","");
            System.out.println("Connection!!!!");
            return connection;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
}
