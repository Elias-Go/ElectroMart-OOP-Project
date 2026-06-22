package com.mycompany.componentmarketplace;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private Connection connection;

    // Constructor establishes the live connection
    public DatabaseManager(String url, String username, String password) {
        try {
            // Explicitly forces Java to load the SQLite driver class into memory
            Class.forName("org.sqlite.JDBC");

            this.connection = DriverManager.getConnection(url);
            System.out.println("✅ Database connection established successfully!");
        } catch (Exception e) {
            System.err.println("❌ Database Connection Failed: " + e.getMessage());
        }
    }

    // --- USER AUTHENTICATION ---
    public User authenticateUser(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("user_id");
                String name = rs.getString("name");
                String role = rs.getString("role");

                if (role.equalsIgnoreCase("Admin")) {
                    return new Admin(id, name, email, password);
                } else {
                    String address = rs.getString("address");
                    return new Customer(id, name, email, password, address);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Login failed
    }

    // --- FETCH INVENTORY ---
    public List<Product> getAllProducts() {
        List<Product> catalog = new ArrayList<>();
        String query = "SELECT * FROM products";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int stock = rs.getInt("quantity_in_stock");
                String category = rs.getString("category");
                String attr1 = rs.getString("attribute_1");
                String attr2 = rs.getString("attribute_2");

                // Polymorphic instantiation based on database category
                if (category.equalsIgnoreCase("Microcontroller")) {
                    catalog.add(new Microcontroller(id, name, price, stock, attr1, Double.parseDouble(attr2)));
                } else if (category.equalsIgnoreCase("Sensor")) {
                    catalog.add(new Sensor(id, name, price, stock, attr1, Double.parseDouble(attr2)));
                } else if (category.equalsIgnoreCase("Semiconductor")) {
                    catalog.add(new Semiconductor(id, name, price, stock, attr1, attr2));
                }
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
        return catalog;
    }

    // --- SAVE ORDER ---
    public boolean saveOrder(Order order) {
        String query = "INSERT INTO orders (user_id, total_amount, status) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, order.getUserId());
            stmt.setDouble(2, order.getTotalAmount());
            stmt.setString(3, order.getStatus());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}