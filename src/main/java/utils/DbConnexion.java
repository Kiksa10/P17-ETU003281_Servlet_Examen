package utils;

import java.sql.*;

public class DbConnexion {
    private static final String URL = "jdbc:mysql://localhost:3306/db_s2_ETU003281?useSSL=false&serverTimezone=UTC";
    private static final String USER = "ETU003281";  // Correct variable name casing
    private static final String PASSWORD = "XIbu4gJ2";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        // Confirm the connection
        System.out.println("Connected to database successfully!");

        return conn;
    }
}
