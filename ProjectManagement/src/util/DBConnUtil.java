package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnUtil {
    
    public static Connection getConnection(String fileName) {
        Connection con = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Get the connection string from DBPropertyUtil
            String connStr = DBPropertyUtil.getPropertyString(fileName);
            
            // Create connection
            con = DriverManager.getConnection(connStr);
            System.out.println("✅ Database connection established successfully!");
        } catch (Exception e) {
            System.out.println("❌ Error while establishing database connection:");
            e.printStackTrace();
        }
        return con;
    }
}
