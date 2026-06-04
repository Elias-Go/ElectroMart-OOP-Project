package com.mycompany.componentmarketplace;

public class DatabaseManager {
    // Member 4 will configure these
    private static final String URL = "jdbc:mysql://localhost:3306/electromart_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static boolean connect() {
        // Member 4 will write JDBC connection logic
        return false;
    }

    public static void saveOrder(Order order) {
        // Member 4 will write INSERT SQL logic here
    }
}