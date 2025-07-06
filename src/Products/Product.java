package Products;

public abstract class Product {
    String name;
    int price;
    int quantity;

    public String getName(){
        return name;
    };

    public double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public void decreaseQuantity(int amount){
        if (amount > quantity) {
            throw new IllegalArgumentException("Amount exceeds available quantity");
        }
        quantity -= amount;
    }

    public boolean isExpired(){
        // Placeholder for expiration logic
        return false;
    }
}
