package com.mycompany.componentmarketplace;

public abstract class User {
    private int userId;
    private String name;
    private String email;
    private String password;

    // Full Constructor
    public User(int userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Core Operational Methods
    public boolean login(String enteredEmail, String enteredPassword) {
        // Member 3 will implement real database validation here later
        return false;
    }

    public void logout() {
        System.out.println("User " + this.name + " has successfully logged out.");
    }

    // --- GETTERS AND SETTERS FOR ALL FIELDS ---

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}