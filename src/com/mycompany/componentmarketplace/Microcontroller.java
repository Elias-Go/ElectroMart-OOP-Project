package com.mycompany.componentmarketplace;

public class Microcontroller extends Product {
    private String memorySize;
    private double clockSpeed; // Stored in MHz

    // Constructor passing core details to Product and initializing unique fields
    public Microcontroller(int productId, String name, double price, int stockQuantity, String memorySize, double clockSpeed) {
        super(productId, name, price, stockQuantity);
        this.memorySize = memorySize;
        this.clockSpeed = clockSpeed;
    }

    // Implementing the abstract method from the parent class
    @Override
    public void displayDetails() {
        System.out.println("--- Microcontroller Details ---");
        System.out.println("ID: " + getProductId());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Stock: " + getStockQuantity() + " units");
        System.out.println("Memory: " + this.memorySize);
        System.out.println("Clock Speed: " + this.clockSpeed + " MHz");
    }

    // --- GETTERS AND SETTERS FOR UNIQUE FIELDS ---

    public String getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(String memorySize) {
        this.memorySize = memorySize;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }
}