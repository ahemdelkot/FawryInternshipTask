import Products.Product;
import Products.Shippable;

public class CheckOut {

    void CheckOut(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty. Cannot proceed to checkout.");
        }
        for (CartItem item : cart.getItems()) {
            if (item.getProduct().isExpired())
                throw new IllegalArgumentException("Cannot checkout expired product: " + item.getProduct().getName());
            if (item.getQuantity() > item.getProduct().getQuantity()) {
                throw new IllegalArgumentException("Requested quantity exceeds available stock for product: " + item.getProduct().getName());
            }
        }
        if (customer.getBalance() < cart.getTotalPrice()) {
                throw new IllegalStateException("Insufficient balance. Cannot proceed to checkout.");
        }
        printReceipt(customer, cart);
    }
    private void printReceipt(Customer customer, Cart cart) {
        System.out.println("** Shipment notice **");

        double totalWeight = 0;

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();

            if (product instanceof Shippable s) {
                double itemWeight = s.getWeight() * item.getQuantity();
                totalWeight += itemWeight;

                System.out.printf("%-3dx %-12s %6.0f g%n",
                        item.getQuantity(),
                        s.getName(),
                        itemWeight
                );
            }
        }

        System.out.printf("Total package weight %.1f kg%n", totalWeight);

        System.out.println();

        System.out.println("** Checkout receipt **");

        double subtotal = 0;
        for (CartItem item : cart.getItems()) {
            double itemTotal = item.getProduct().getPrice() * item.getQuantity();
            subtotal += itemTotal;

            // Print: 2x Cheese       200 EGP
            System.out.printf("%-3dx %-12s %6.0f EGP%n",
                    item.getQuantity(),
                    item.getProduct().getName(),
                    itemTotal
            );
        }

        double shippingFees = (subtotal*.025);
        double amount = subtotal + shippingFees;

        System.out.println("----------------------");
        System.out.printf("%-17s %6.0f EGP%n", "Subtotal", subtotal);
        System.out.printf("%-17s %6.0f EGP%n", "Shipping", shippingFees);
        System.out.printf("%-17s %6.0f EGP%n", "Amount", amount);

    }
}
