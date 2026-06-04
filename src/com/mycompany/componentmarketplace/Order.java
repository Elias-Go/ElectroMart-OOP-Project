package com.mycompany.componentmarketplace;

import java.util.Date;
import java.util.HashMap;

public class Order {
    private int orderId;
    private Customer customer;
    private HashMap<Product, Integer> orderedItems;
    private double totalAmount;
    private Date orderDate;

    // Full Constructor
    public Order(int orderId, Customer customer, HashMap<Product, Integer> orderedItems, double totalAmount) {
        this.orderId = orderId;
        this.customer = customer;
        // Creating a new HashMap copy ensures the order history stays unchanged
        // even if the customer clears out their live shopping cart later.
        this.orderedItems = new HashMap<>(orderedItems);
        this.totalAmount = totalAmount;
        this.orderDate = new Date(); // Automatically timestamps the order to "Right Now"
    }

    // Core Operational Methods
    public void processOrder() {
        // Member 3 will write logic to deduct final stock counts from the inventory
        System.out.println("Processing order ID: " + this.orderId + " for " + customer.getName());
    }

    public void printInvoice() {
        // Member 3 will write logic to print a clean receipt to the terminal or a file
        System.out.println("=== INVOICE FOR ORDER #" + this.orderId + " ===");
        System.out.println("Date: " + this.orderDate);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Total Amount Paid: $" + this.totalAmount);
    }

    // --- GETTERS AND SETTERS FOR ALL FIELDS ---

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public HashMap<Product, Integer> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(HashMap<Product, Integer> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}