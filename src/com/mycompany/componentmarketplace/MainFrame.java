package com.mycompany.componentmarketplace;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class MainFrame extends JFrame {
    private DatabaseManager dbManager;
    private User currentUser;
    private Cart currentCart;

    // UI Navigation Components
    private CardLayout cardLayout;
    private JPanel mainCardPanel;

    public MainFrame() {
        // ⚠️ THE 3 STRINGS TO CHANGE FOR YOUR LOCAL MACHINE
        this.dbManager = new DatabaseManager("jdbc:sqlite:electromart.db", "", "");

        // Set up the main application window
        setTitle("ElectroMart Command Center");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centers window on screen

        cardLayout = new CardLayout();
        mainCardPanel = new JPanel(cardLayout);

        // Build and add the three main screens
        mainCardPanel.add(buildLoginScreen(), "LOGIN");
        mainCardPanel.add(buildCustomerScreen(), "CUSTOMER");
        mainCardPanel.add(buildAdminScreen(), "ADMIN");

        add(mainCardPanel);

        // Start the app on the Login Screen
        cardLayout.show(mainCardPanel, "LOGIN");
    }

    // ==========================================
    // 1. LOGIN SCREEN
    // ==========================================
    private JPanel buildLoginScreen() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(45, 52, 54));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("ELECTROMART LOGIN");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JTextField emailField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginBtn = new JButton("Secure Login");

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; panel.add(titleLabel, gbc);
        gbc.gridwidth = 1;
        gbc.gridy = 1; panel.add(new JLabel("<html><font color='white'>Email:</font></html>"), gbc);
        gbc.gridx = 1; panel.add(emailField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(new JLabel("<html><font color='white'>Password:</font></html>"), gbc);
        gbc.gridx = 1; panel.add(passwordField, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; panel.add(loginBtn, gbc);

        // Login Logic
        loginBtn.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            currentUser = dbManager.authenticateUser(email, password);

            if (currentUser != null) {
                if (currentUser.getRole().equalsIgnoreCase("Admin")) {
                    cardLayout.show(mainCardPanel, "ADMIN");
                } else {
                    // Initialize a fresh cart for the customer
                    currentCart = new Cart((int)(Math.random() * 1000));
                    cardLayout.show(mainCardPanel, "CUSTOMER");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.", "Access Denied", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }

    // ==========================================
    // 2. CUSTOMER SCREEN
    // ==========================================
    private JPanel buildCustomerScreen() {
        JPanel panel = new JPanel(new BorderLayout());

        // Top Banner
        JLabel welcomeLabel = new JLabel("  Welcome to the Storefront! Select items to add to your cart.");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(welcomeLabel, BorderLayout.NORTH);

        // Catalog Table
        String[] columns = {"ID", "Name", "Category", "Price ($)", "Stock"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable catalogTable = new JTable(tableModel);

        // Fetch live data
        List<Product> catalog = dbManager.getAllProducts();
        for (Product p : catalog) {
            tableModel.addRow(new Object[]{p.getProductId(), p.getName(), p.getCategory(), p.getPrice(), p.getQuantityInStock()});
        }
        panel.add(new JScrollPane(catalogTable), BorderLayout.CENTER);

        // Bottom Controls
        JPanel bottomPanel = new JPanel();
        JButton addToCartBtn = new JButton("Add Selected to Cart");
        JButton checkoutBtn = new JButton("Checkout");

        addToCartBtn.addActionListener(e -> {
            int selectedRow = catalogTable.getSelectedRow();
            if (selectedRow >= 0) {
                // Find the exact polymorphic object from the list and add it to cart
                Product selectedProduct = catalog.get(selectedRow);
                currentCart.addItem(selectedProduct);
                JOptionPane.showMessageDialog(this, selectedProduct.getName() + " added to cart!");
            }
        });

        checkoutBtn.addActionListener(e -> {
            if (currentCart == null || currentCart.getItems().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Your cart is empty!");
                return;
            }
            double total = currentCart.calculateTotal();
            Order newOrder = new Order(0, currentUser.getUserId(), total, "Processing");

            if (dbManager.saveOrder(newOrder)) {
                JOptionPane.showMessageDialog(this, "Checkout Successful! Total: $" + String.format("%.2f", total));
                currentCart.clearCart(); // Empty cart after purchase
            } else {
                JOptionPane.showMessageDialog(this, "Transaction Failed. Database error.");
            }
        });

        bottomPanel.add(addToCartBtn);
        bottomPanel.add(checkoutBtn);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;
    }

    // ==========================================
    // 3. ADMIN SCREEN
    // ==========================================
    private JPanel buildAdminScreen() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel adminLabel = new JLabel("  Administrator Dashboard - Inventory Management");
        adminLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(adminLabel, BorderLayout.NORTH);

        // Admin Table View
        String[] columns = {"ID", "Name", "Category", "Price", "Stock"};
        DefaultTableModel adminTableModel = new DefaultTableModel(columns, 0);
        JTable adminTable = new JTable(adminTableModel);

        List<Product> catalog = dbManager.getAllProducts();
        for (Product p : catalog) {
            adminTableModel.addRow(new Object[]{p.getProductId(), p.getName(), p.getCategory(), p.getPrice(), p.getQuantityInStock()});
        }
        panel.add(new JScrollPane(adminTable), BorderLayout.CENTER);

        // Quick Insert Panel
        JPanel insertPanel = new JPanel();
        JTextField nameField = new JTextField(10);
        JTextField priceField = new JTextField(5);
        JTextField stockField = new JTextField(5);
        JComboBox<String> categoryBox = new JComboBox<>(new String[]{"Microcontroller", "Sensor", "Semiconductor"});
        JButton saveBtn = new JButton("Save to DB");

        insertPanel.add(new JLabel("Name:")); insertPanel.add(nameField);
        insertPanel.add(new JLabel("Price:")); insertPanel.add(priceField);
        insertPanel.add(new JLabel("Stock:")); insertPanel.add(stockField);
        insertPanel.add(new JLabel("Type:")); insertPanel.add(categoryBox);
        insertPanel.add(saveBtn);

        panel.add(insertPanel, BorderLayout.SOUTH);

        // Direct JDBC Insert logic for Admin
        saveBtn.addActionListener(e -> {
            try {
                // We open a direct, rapid connection strictly for this admin insert
                Connection conn = DriverManager.getConnection("jdbc:sqlite:electromart.db");
                String query = "INSERT INTO products (name, price, quantity_in_stock, category, attribute_1, attribute_2) VALUES (?, ?, ?, ?, 'Standard', 'N/A')";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, nameField.getText());
                stmt.setDouble(2, Double.parseDouble(priceField.getText()));
                stmt.setInt(3, Integer.parseInt(stockField.getText()));
                stmt.setString(4, categoryBox.getSelectedItem().toString());

                stmt.executeUpdate();
                conn.close();

                JOptionPane.showMessageDialog(this, "Product injected into live database. Restart app to refresh table.");
                nameField.setText(""); priceField.setText(""); stockField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error adding product: " + ex.getMessage());
            }
        });

        return panel;
    }

    // ==========================================
    // MAIN ENTRY POINT
    // ==========================================
    public static void main(String[] args) {
        // Enforces thread safety for Java Swing GUI creation
        SwingUtilities.invokeLater(() -> {
            MainFrame app = new MainFrame();
            app.setVisible(true);
        });
    }
}