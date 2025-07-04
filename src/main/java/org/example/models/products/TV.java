package org.example.models.products;
import org.example.models.Product;
import org.example.models.interfaces.Shippable;

public class TV extends Product implements Shippable {
    private final double weight;

    public TV(String name, double price,int quantity , double weight){
        super(name,price,quantity);
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
