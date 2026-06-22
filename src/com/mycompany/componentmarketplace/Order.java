package com.mycompany.componentmarketplace;

public class Order {
    private int orderId;
    private int userId;
    private double totalAmount;
    private String status;

    // Constructor
    public Order(int orderId, int userId, double totalAmount, String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    // --- ORDER OPERATIONS ---

    // Generates a clean text receipt for the console (optional academic proof of logic)
    public void generateReceipt() {
        System.out.println("==================================");
        System.out.println("         ORDER RECEIPT            ");
        System.out.println("==================================");
        System.out.println("Order ID: " + orderId);
        System.out.println("User ID:  " + userId);
        System.out.println("Status:   " + status);
        System.out.println("Total:    $" + String.format("%.2f", totalAmount));
        System.out.println("==================================");
    }

    // --- GETTERS AND SETTERS ---

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}