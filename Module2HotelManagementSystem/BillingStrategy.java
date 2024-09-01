package Module2HotelManagementSystem;

// BillingStrategy interface
public interface BillingStrategy {
    double calculatePrice(MenuItem item);
}

// StandardBillingStrategy class
class StandardBillingStrategy implements BillingStrategy {
    @Override
    public double calculatePrice(MenuItem item) {
        // Returns the original price of the menu item
        return item.getPrice();
    }
}

// DiscountBillingStrategy class
class DiscountBillingStrategy implements BillingStrategy {
    private double discount;

    public DiscountBillingStrategy(double discount) {
        if (discount < 0) {
            throw new IllegalArgumentException("Discount cannot be negative.");
        }
        this.discount = discount;
    }

    @Override
    public double calculatePrice(MenuItem item) {
        // Ensure the discount does not exceed the item's price
        double discountedPrice = item.getPrice() - discount;
        return Math.max(discountedPrice, 0);
    }
}
