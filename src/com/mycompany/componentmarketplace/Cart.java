package com.mycompany.componentmarketplace;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int cartId;
    private List<Product> items;

    // Constructor
    public Cart(int cartId) {
        this.cartId = cartId;
        // Instantiate the empty list so it is ready to receive items
        this.items = new ArrayList<>();
    }

    // --- CART OPERATIONS ---

    public void addItem(Product product) {
        this.items.add(product);
    }

    public void removeItem(Product product) {
        this.items.remove(product);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void clearCart() {
        this.items.clear();
    }

    // --- GETTERS ---

    public List<Product> getItems() {
        return items;
    }

    public int getCartId() {
        return cartId;
    }
}