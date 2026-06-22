package com.mycompany.componentmarketplace;

public class Sensor extends Product {
    private String sensorType;
    private double precision;

    // Constructor
    public Sensor(int productId, String name, double price, int quantityInStock, String sensorType, double precision) {
        // Automatically categorizes this instance as a "Sensor"
        super(productId, name, price, quantityInStock, "Sensor");
        this.sensorType = sensorType;
        this.precision = precision;
    }

    // --- GETTERS AND SETTERS ---

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }
}