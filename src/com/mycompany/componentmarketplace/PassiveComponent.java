package com.mycompany.componentmarketplace;

public class PassiveComponent extends Product {
    private String componentValue;
    private String tolerance;

    // Constructor passing core details to Product and initializing unique fields
    public PassiveComponent(int productId, String name, double price, int stockQuantity, String componentValue, String tolerance) {
        super(productId, name, price, stockQuantity);
        this.componentValue = componentValue;
        this.tolerance = tolerance;
    }

    // Implementing the abstract method from the parent class
    @Override
    public void displayDetails() {
        System.out.println("--- Passive Component Details ---");
        System.out.println("ID: " + getProductId());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Stock: " + getStockQuantity() + " units");
        System.out.println("Value: " + this.componentValue);
        System.out.println("Tolerance: " + this.tolerance);
    }

    // --- GETTERS AND SETTERS FOR UNIQUE FIELDS ---

    public String getComponentValue() {
        return componentValue;
    }

    public void setComponentValue(String componentValue) {
        this.componentValue = componentValue;
    }

    public String getTolerance() {
        return tolerance;
    }

    public void setTolerance(String tolerance) {
        this.tolerance = tolerance;
    }
}