package com.mycompany.componentmarketplace;

public class Customer extends User {
    private String address;

    // Constructor
    public Customer(int userId, String name, String email, String password, String address) {
        // super() calls the constructor of the parent class (User)
        super(userId, name, email, password);
        this.address = address;
    }

    // Core Operational Methods
    public void register() {
        // Member 3 will write the logic to save a new customer to the database here
        System.out.println("Customer registration logic will execute here.");
    }

    public void viewPurchaseHistory() {
        // Member 3 will write the logic to fetch past orders from the database
        System.out.println("Displaying purchase history for: " + this.getName());
    }

    public void viewOrders() {
        // Member 3 will write the logic to view current/active orders
        System.out.println("Displaying current orders for: " + this.getName());
    }

    // --- GETTERS AND SETTERS ---

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}