package com.mycompany.componentmarketplace;

public class Customer extends User {
    private String address;

    // Constructor
    public Customer(int userId, String name, String email, String password, String address) {
        // Passes user details and forces the "Customer" role up to the parent User class
        super(userId, name, email, password, "Customer");
        this.address = address;
    }

    // --- GETTERS AND SETTERS ---

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}