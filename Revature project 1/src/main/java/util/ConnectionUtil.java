package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {


    public static Connection getConnection(){
        Connection conn = null;

        String url = "jdbc:postgresql://revature-fullstack-java-database.cnxdgkl9hdlv.us-east-1.rds.amazonaws.com/Project1";
        String username = "postgres";
        String password = "p4ssw0rd";
        try{
            conn = DriverManager.getConnection(url, username, password);
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return conn;
    }
}
