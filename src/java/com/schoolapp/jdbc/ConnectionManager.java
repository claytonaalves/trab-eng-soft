package com.schoolapp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author clayton
 */
public class ConnectionManager {
 
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite://tmp/teste.db");
        } 
        catch (ClassNotFoundException | SQLException e) {
            
        }
        return conn;
    }
        
}
