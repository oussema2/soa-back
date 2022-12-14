package org.example.DAO;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionSingleton {

    private static Connection conn;

    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionlivre?autoReconnect=true&useSSL=false","root","lcspro");
            return conn;
        }catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }
}
