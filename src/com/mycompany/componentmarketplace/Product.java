package com.mycompany.componentmarketplace;

public abstract class Product {
    private int productId;
    private String name;
    private double price;
    private int stockQuantity;

    // Full Constructor
    public Product(int productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Abstract method forcing ALL child classes to implement this (Polymorphism)
    public abstract void displayDetails();

    // Core Operational Method
    public void updateStock(int quantity) {
        // Adds to the stock (or subtracts if the quantity is negative)
        this.stockQuantity += quantity;
        System.out.println("Stock updated. New quantity for " + this.name + " is " + this.stockQuantity);
    }

    // --- GETTERS AND SETTERS FOR ALL FIELDS ---

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}