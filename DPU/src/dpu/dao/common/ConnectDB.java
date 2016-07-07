package dpu.dao.common;

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.log4j.Logger;
import properties.ReadFromPropertiesFile;

public class ConnectDB {

    static ConnectDB connectDB = null;
    static ReadFromPropertiesFile readFromPropertiesFile = ReadFromPropertiesFile.getInstance();
    static Logger logger = Logger.getLogger(ConnectDB.class);

    private ConnectDB() {
    }

    public static ConnectDB getInstance() {
        if (connectDB == null) {
            connectDB = new ConnectDB();
        }
        return connectDB;
    }

    public static Connection connect() {
        Connection conn = null;
        String url = readFromPropertiesFile.getProperty("jdbc.url");
        String database = readFromPropertiesFile.getProperty("jdbc.database");
        String username = readFromPropertiesFile.getProperty("jdbc.username");
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url + database, username, password);
        } catch (Exception e) {
            System.out.println(e);
            logger.error("ConnectDB : connect : " + e);
        }
        return conn;
    }

}
