package util;

import java.io.InputStream;
import java.util.Properties;

public class DBPropertyUtil {
    public static String getPropertyString(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream input = ClassLoader.getSystemResourceAsStream(fileName);
            Properties props = new Properties();
            props.load(input);
            
            sb.append("jdbc:mysql://");
            sb.append(props.getProperty("host"));
            sb.append(":");
            sb.append(props.getProperty("port"));
            sb.append("/");
            sb.append(props.getProperty("database"));
            sb.append("?user=");
            sb.append(props.getProperty("user"));
            sb.append("&password=");
            sb.append(props.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
