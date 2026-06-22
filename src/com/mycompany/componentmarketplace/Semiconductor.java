package com.mycompany.componentmarketplace;

public class Semiconductor extends Product {
    private String type;
    private double voltageRating;

    // Constructor passing core details to Product and initializing unique fields
    public Semiconductor(int productId, String name, double price, int stockQuantity, String type, String voltageRating) {
        super(productId, name, price, stockQuantity);
        this.type = type;
        this.voltageRating = voltageRating;
    }

    // Implementing the abstract method from the parent class (Polymorphism)
    @Override
    public void displayDetails() {
        System.out.println("--- Semiconductor Details ---");
        System.out.println("ID: " + getProductId());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Stock: " + getStockQuantity() + " units");
        System.out.println("Type: " + this.type);
        System.out.println("Voltage Rating: " + this.voltageRating + "V");
    }

    // --- GETTERS AND SETTERS FOR UNIQUE FIELDS ---

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getVoltageRating() {
        return voltageRating;
    }

    public void setVoltageRating(double voltageRating) {
        this.voltageRating = voltageRating;
    }
}