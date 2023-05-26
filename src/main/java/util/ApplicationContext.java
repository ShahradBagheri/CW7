package util;

import java.sql.Connection;

public class ApplicationContext {
    private static Connection connection;
    public static Connection getConnection(){
        if (connection != null){
            return connection;
        }else {
            connection = new ConnectionUtils().getConnection();
            return connection;
        }

    }
}
