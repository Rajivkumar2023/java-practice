package com.company.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/loginreg";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Rajiv@2023";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Consider using a logger instead of printStackTrace in production
        }
    }

    public static Connection getConnection() throws SQLException {
        System.out.println("Connection is being established!"); // Replace with a logger in production
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
