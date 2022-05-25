package com.example.t2009m1demo.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/t2009m1-demo";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";

    public static Connection connection;
    public  static  Connection getConnection(){
        try {
            if (connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
