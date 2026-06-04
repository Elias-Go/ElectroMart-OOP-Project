package com.mycompany.componentmarketplace;

public class Admin extends User {

    // Constructor passing parameters to the parent User class
    public Admin(int userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    // Core Operational Methods
    public void addProduct(Product product) {
        // Member 3 will link this to Inventory and Database later
        System.out.println("Admin " + getName() + " is adding product: " + product.getName());
    }

    public void updateProduct(Product product) {
        // Member 3 will implement logic to modify an existing product
        System.out.println("Admin " + getName() + " is updating product: " + product.getName());
    }

    public void deleteProduct(Product product) {
        // Member 3 will implement logic to remove a product from the database
        System.out.println("Admin " + getName() + " is deleting product: " + product.getName());
    }

    public void manageInventory() {
        // Member 3 will implement general inventory management tracking here
        System.out.println("Admin " + getName() + " is accessing inventory management panel.");
    }
}