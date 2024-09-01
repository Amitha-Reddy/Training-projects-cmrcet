package Module2HotelManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    // Adds an item to the order
    public void addItem(MenuItem item) {
        if (item != null) {
            items.add(item);
        } else {
            throw new IllegalArgumentException("Cannot add null item to the order.");
        }
    }

    // Prints all items in the order
    public void printOrder() {
        if (items.isEmpty()) {
            System.out.println("The order is empty.");
        } else {
            for (MenuItem item : items) {
                System.out.println(item);
            }
        }
    }

    // Calculates the total price using the given billing strategy
    public double calculateTotal(BillingStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("BillingStrategy cannot be null.");
        }

        return items.stream()
                .mapToDouble(strategy::calculatePrice)
                .sum();
    }
}
