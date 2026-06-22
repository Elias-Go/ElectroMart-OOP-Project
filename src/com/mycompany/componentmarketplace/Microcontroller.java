package com.mycompany.componentmarketplace;

public class Microcontroller extends Product {
    private String architecture;
    private double clockSpeedGHz;

    // Constructor
    public Microcontroller(int productId, String name, double price, int quantityInStock, String architecture, double clockSpeedGHz) {
        // Automatically sets the category to "Microcontroller" in the parent Product class
        super(productId, name, price, quantityInStock, "Microcontroller");
        this.architecture = architecture;
        this.clockSpeedGHz = clockSpeedGHz;
    }

    // --- GETTERS AND SETTERS ---

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public double getClockSpeedGHz() {
        return clockSpeedGHz;
    }

    public void setClockSpeedGHz(double clockSpeedGHz) {
        this.clockSpeedGHz = clockSpeedGHz;
    }
}