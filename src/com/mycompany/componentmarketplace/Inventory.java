package com.mycompany.componentmarketplace;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> productList;

    // Constructor
    public Inventory() {
        this.productList = new ArrayList<>(); // Initializes an empty warehouse
    }

    // Core Operational Methods
    public void addProduct(Product product) {
        // Member 2 will write the exact logic to add items to the list/database
        System.out.println("Adding product to inventory: " + product.getName());
    }

    public void removeProduct(Product product) {
        // Member 2 will write the logic to remove items safely
        System.out.println("Removing product from inventory: " + product.getName());
    }

    public ArrayList<Product> searchProduct(String keyword) {
        // Member 2 will write search algorithms (like looping through the list to match names)
        System.out.println("Searching inventory for keyword: " + keyword);
        return new ArrayList<>(); // Returns an empty list as a placeholder
    }

    // --- GETTERS AND SETTERS ---

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
}