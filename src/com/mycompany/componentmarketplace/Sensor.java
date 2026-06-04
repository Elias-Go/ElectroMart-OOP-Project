package com.mycompany.componentmarketplace;

public class Sensor extends Product {
    private String sensorType;
    private String measurementRange;

    // Constructor passing core details to Product and initializing unique fields
    public Sensor(int productId, String name, double price, int stockQuantity, String sensorType, String measurementRange) {
        super(productId, name, price, stockQuantity);
        this.sensorType = sensorType;
        this.measurementRange = measurementRange;
    }

    // Implementing the abstract method from the parent class
    @Override
    public void displayDetails() {
        System.out.println("--- Sensor Details ---");
        System.out.println("ID: " + getProductId());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Stock: " + getStockQuantity() + " units");
        System.out.println("Type: " + this.sensorType);
        System.out.println("Range: " + this.measurementRange);
    }

    // --- GETTERS AND SETTERS FOR UNIQUE FIELDS ---

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getMeasurementRange() {
        return measurementRange;
    }

    public void setMeasurementRange(String measurementRange) {
        this.measurementRange = measurementRange;
    }
}