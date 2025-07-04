package org.example.services;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.models.interfaces.Shippable;

public class ShippingService {

    public void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");

        Map<String, ShipmentItem> grouped = new HashMap<>();
        double totalWeight = 0;

        for (Shippable item : items) {
            String name = item.getName();
            double weight = item.getWeight();

            grouped.putIfAbsent(name, new ShipmentItem(name, weight, 0));
            grouped.get(name).incrementQuantity();

            totalWeight += weight;
        }

        for (ShipmentItem shipmentItem : grouped.values()) {
            System.out.printf("%dx %-12s %.0fg\n",
                    shipmentItem.quantity,
                    shipmentItem.name,
                    shipmentItem.weight * 1000 * shipmentItem.quantity
            );
        }

        System.out.printf("Total package weight %.1fkg\n\n", totalWeight);
    }

    private static class ShipmentItem {
        private final String name;
        private final double weight;
        private int quantity;

        ShipmentItem(String name, double weight, int quantity) {
            this.name = name;
            this.weight = weight;
            this.quantity = quantity;
        }

        void incrementQuantity() {
            this.quantity++;
        }
    }
}