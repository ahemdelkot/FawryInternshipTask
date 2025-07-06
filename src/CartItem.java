import Products.Product;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product) {
        this.product = product;
        quantity = 1;
    }

   double getTotalPrice(){

        return product.getPrice() * quantity;
    }
    Product getProduct() {
        return product;
    }
    int getQuantity() {
        return quantity;
    }
    void setQuantity(int quantity) {
        if (quantity < 0 ) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("available quantity is " + product.getQuantity() + ", cannot set to " + quantity + "");
        }
        this.quantity = quantity;
   }
}
