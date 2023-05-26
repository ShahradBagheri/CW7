package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtils {
    private String url = "jdbc:postgresql://localhost:5432/UserRepository";
    private String user = "postgres";
    private String password = "12161213";

    public Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connection created");
            return connection;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void save(){

    }
}
