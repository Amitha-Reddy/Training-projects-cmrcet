package Module2HotelManagementSystem;

// Abstract base class for menu items
public abstract class MenuItem {
    private final String name;
    private final double price;

    // Constructor to initialize the menu item
    public MenuItem(String name, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.name = name;
        this.price = price;
    }

    // Getter for the name of the menu item
    public String getName() {
        return name;
    }

    // Getter for the price of the menu item
    public double getPrice() {
        return price;
    }

    // Display the menu item details
    public void display() {
        System.out.printf("%s: $%.2f%n", name, price);
    }

    @Override
    public String toString() {
        return String.format("%s: $%.2f", name, price);
    }
}
