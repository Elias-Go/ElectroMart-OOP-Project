package com.mycompany.componentmarketplace;

public class Admin extends User {

    // Constructor
    public Admin(int userId, String name, String email, String password) {
        // Passes the specific "Admin" role up to the parent User class
        super(userId, name, email, password, "Admin");
    }

}