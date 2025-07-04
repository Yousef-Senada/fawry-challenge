package org.example.models.products;
import java.time.LocalDate;

import org.example.models.Product;
import org.example.models.interfaces.Expirable;
import org.example.models.interfaces.Shippable;

public class Biscuit extends Product implements Expirable,Shippable {
    private final LocalDate expiryDate;
    private final double weight;

    public Biscuit(String name, double price,int quantity , LocalDate expiryDate, double weight){
        super(name,price,quantity);
        if (expiryDate == null) {
            throw new IllegalArgumentException("Expiry date required");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public LocalDate getExpirayDate() {
        return expiryDate;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
