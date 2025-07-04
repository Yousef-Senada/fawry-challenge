package org.example.models;

public abstract class Product {
    private final String name;
    private final double price;
    private int quantity;

    protected Product(String name, double price, int quantity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price can't be negative");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity can't be negative");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount){
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (amount > quantity) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        quantity -= amount;
    }

    public boolean isAvailable(int reduceQuantity){
        return reduceQuantity > 0 && quantity >= reduceQuantity;
    }
}
