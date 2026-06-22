package com.mycompany.componentmarketplace;

public abstract class User {
    private int userId;
    private String name;
    private String email;
    private String password;

    // Constructor
    public User(int userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * NEW LOGIC: Authentication System
     * Checks if the provided password matches the user's secure password.
     * @param inputPassword The password typed into the GUI
     * @return true if it matches, false if it is incorrect
     */
    public boolean authenticate(String inputPassword) {
        // String.equals() is used for secure string comparison in Java
        if (this.password != null && this.password.equals(inputPassword)) {
            System.out.println("User authenticated successfully: " + this.name);
            return true;
        }
        System.out.println("Authentication failed for user: " + this.name);
        return false;
    }

    // Abstract method forcing Customer and Admin to have their own specific dashboards
    public abstract void displayRole();

    // --- GETTERS AND SETTERS ---
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