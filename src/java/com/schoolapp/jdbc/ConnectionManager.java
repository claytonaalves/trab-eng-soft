package com.schoolapp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author clayton
 */
public class ConnectionManager {

    private static Connection conn = null;
 
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:///home/clayton/NetBeansProjects/SchoollApp/database/database.db");
            } 
            catch (ClassNotFoundException | SQLException e) {

            }
        }
        return conn;
    }
        
}
