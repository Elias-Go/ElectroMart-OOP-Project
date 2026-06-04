package com.mycompany.componentmarketplace;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Inventory inventory;
    private DatabaseManager dbManager;

    // Constructor setting up the core application window
    public MainFrame() {
        // Window metadata setup
        setTitle("ElectroMart: Component Marketplace");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centers the window on the computer screen

        // Initializing the system's structural components
        this.inventory = new Inventory();
        this.dbManager = new DatabaseManager();

        // Setting up CardLayout for seamless screen-switching
        this.cardLayout = new CardLayout();
        this.mainPanel = new JPanel(this.cardLayout);

        // Placeholder content panel so the window isn't completely blank at startup
        JPanel welcomePanel = new JPanel(new GridBagLayout());
        welcomePanel.add(new JLabel("Welcome to ElectroMart Component Marketplace!"));

        // Registering the placeholder screen into the layout manager
        this.mainPanel.add(welcomePanel, "WELCOME");
        add(this.mainPanel);
    }

    // Navigation helper methods
    public void showWelcomeScreen() {
        this.cardLayout.show(this.mainPanel, "WELCOME");
    }

    // Main execution point to run your desktop application
    public static void main(String[] args) {
        // Thread-safe invocation ensures the Swing GUI initializes reliably
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }

    // --- GETTERS AND SETTERS FOR ALL PRIVATE UI & INFRASTRUCTURE FIELDS ---

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public DatabaseManager getDbManager() {
        return dbManager;
    }

    public void setDbManager(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }
}