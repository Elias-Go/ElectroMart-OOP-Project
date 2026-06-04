package com.mycompany.componentmarketplace;

import java.util.HashMap;

public class Cart {
    private Customer customer;
    private HashMap<Product, Integer> items;

    // Constructor
    public Cart(Customer customer) {
        this.customer = customer;
        this.items = new HashMap<>(); // Initializes an empty cart for the customer
    }

    // Core Operational Methods
    public void addItem(Product product, int quantity) {
        // Member 3 will write logic to add or update item quantities in the map
        System.out.println("Added " + quantity + "x " + product.getName() + " to the cart.");
    }

    public void removeItem(Product product) {
        // Member 3 will write logic to remove an item completely
        System.out.println("Removed " + product.getName() + " from the cart.");
    }

    public double calculateTotal() {
        // Member 3 will iterate through the HashMap to calculate the total price
        return 0.0;
    }

    // --- GETTERS AND SETTERS ---

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public HashMap<Product, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<Product, Integer> items) {
        this.items = items;
    }
}