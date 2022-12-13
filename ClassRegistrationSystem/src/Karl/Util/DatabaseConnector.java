package Karl.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// database connector
public class DatabaseConnector {
    public static Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite::resource:ClassRegistrationSystem.db");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }
}
