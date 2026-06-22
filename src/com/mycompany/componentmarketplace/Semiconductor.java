package com.mycompany.componentmarketplace;

public class Semiconductor extends Product {
    private String material;
    private String packageType;

    // Constructor
    public Semiconductor(int productId, String name, double price, int quantityInStock, String material, String packageType) {
        // Automatically flags this specific item as a "Semiconductor"
        super(productId, name, price, quantityInStock, "Semiconductor");
        this.material = material;
        this.packageType = packageType;
    }

    // --- GETTERS AND SETTERS ---

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }
}