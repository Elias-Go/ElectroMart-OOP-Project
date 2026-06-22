package com.mycompany.componentmarketplace;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> productList;

    // Constructor
    public Inventory() {
        // Initialize the empty list so it's ready to receive data from the DatabaseManager
        this.productList = new ArrayList<>();
    }

    // --- INVENTORY OPERATIONS ---

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public void removeProduct(Product product) {
        this.productList.remove(product);
    }

    public boolean checkStock(int productId, int requestedQuantity) {
        for (Product p : productList) {
            if (p.getProductId() == productId) {
                return p.getQuantityInStock() >= requestedQuantity;
            }
        }
        return false;
    }

    // --- GETTERS AND SETTERS ---

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}