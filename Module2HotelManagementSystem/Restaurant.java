package Module2HotelManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<MenuItem> menu;

    public Restaurant() {
        menu = new ArrayList<>();
    }

    // Getter for restaurant name
    public String getName() {
        return name;
    }

    // Setter for restaurant name with validation
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Restaurant name cannot be null or empty.");
        }
        this.name = name;
    }

    // Add a menu item with null check
    public void addMenuItem(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item to the menu.");
        }
        menu.add(item);
    }

    // Find a menu item by name with null check
    public MenuItem findMenuItemByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Menu item name cannot be null or empty.");
        }

        for (MenuItem item : menu) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null; // Return null if item is not found
    }

    // Print the menu items with a message if the menu is empty
    public void printMenu() {
        if (menu.isEmpty()) {
            System.out.println("The menu is empty.");
        } else {
            for (MenuItem item : menu) {
                System.out.println(item);
            }
        }
    }
}
