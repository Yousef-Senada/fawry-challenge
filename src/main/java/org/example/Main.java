package org.example;
import java.time.LocalDate;

import org.example.models.Cart;
import org.example.models.Customer;
import org.example.models.Product;
import org.example.models.products.Biscuit;
import org.example.models.products.Cheese;
import org.example.models.products.ScratchCard;
import org.example.models.products.TV;
import org.example.services.CheckoutService;

public class Main {
    public static void main(String[] args) {
        Product cheese = new Cheese("Cheese", 100, 10, LocalDate.of(2025, 7, 11), 0.2);

        Product biscuit = new Biscuit("Biscuits", 150, 14, LocalDate.now().plusDays(180), 0.7);

        Product tv = new TV("tv-samsung", 8000, 5, 10);

        Product scratchCard = new ScratchCard("Vodafone", 16, 20);

        Customer customer = new Customer("Yousef Ashraf", 10000);

        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(biscuit, 2);
        cart.add(tv, 1);
        cart.add(scratchCard, 1);

        CheckoutService checkoutService = new CheckoutService();
        try{
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Failed: " + e.getMessage());
        }
    }   
}
