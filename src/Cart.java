import Products.Product;

import java.util.*;

public class Cart {
    private List<CartItem> items ;
    private double totalPrice;

    Cart(){
        items = new ArrayList<>();
    }

    void addItem(Product item , int quantity) {
        CartItem cartItem = new CartItem(item);
        cartItem.setQuantity(quantity);
        items.add(cartItem);
        totalPrice += cartItem.getTotalPrice();
    }
    void removeItem(CartItem item) {
        if (items.remove(item)) {
            totalPrice -= item.getTotalPrice();
        } else {
            throw new NoSuchElementException("Item not found in cart");
        }
    }
    void clear() {
        items.clear();
        totalPrice = 0;
    }
    List<CartItem> getItems() {
        return items;
    }
    double getTotalPrice() {
        return totalPrice;
    }
    boolean isEmpty() {
        return items.isEmpty();
    }

}
