package org.example.services;
import org.example.models.*;
import org.example.models.interfaces.Expirable;
import org.example.models.interfaces.Shippable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckoutService {

    private final ShippingService shippingService = new ShippingService();

    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        double subtotal = 0;
        List<Shippable> toShip = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product instanceof Expirable) {
                Expirable expirable = (Expirable) product;
                if (expirable.isExpired()) {
                    throw new IllegalStateException(product.getName() + " is expired.");
                }
            }

            if (!product.isAvailable(quantity)) {
                throw new IllegalStateException(product.getName() + " is out of stock.");
            }

            subtotal += product.getPrice() * quantity;

            product.reduceQuantity(quantity);

            if (product instanceof Shippable) {
                for (int i = 0; i < quantity; i++) {
                    toShip.add((Shippable) product);
                }
            }
        }

        double shipping = toShip.isEmpty() ? 0 : 30;
        double total = subtotal + shipping;

        if (customer.getBalance() < total) {
            throw new IllegalStateException("Insufficient balance.");
        }

        customer.pay(total);

        if (!toShip.isEmpty()) {
            shippingService.ship(toShip);
        }

        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            System.out.printf("%dx %-12s %.0f\n", qty, p.getName(), p.getPrice() * qty);
        }

        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f\n", subtotal);
        System.out.printf("Shipping         %.0f\n", shipping);
        System.out.printf("Amount           %.0f\n", total);
        System.out.printf("Remaining balance %.0f\n", customer.getBalance());

        cart.clear();
    }
}