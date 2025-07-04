package org.example.models;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private final Map<Product,Integer> items = new LinkedHashMap<>();

    public void add(Product product, int quantity){

        if (product == null) {
            throw new IllegalArgumentException("Product can't be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be greater than zero");
        }

        int existingQuantity = items.getOrDefault(product, 0);
        int totalRequested = existingQuantity + quantity;

        if (!product.isAvailable(totalRequested)) {
            throw new IllegalArgumentException("Not enough stock for product: "+ product.getName());
        }

        items.put(product, totalRequested);
    }

    public Map<Product,Integer> getItems() {
        return Collections.unmodifiableMap(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
}
