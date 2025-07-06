package Products;

import java.time.LocalDate;

public class Cheese extends ExpirableProduct implements Shippable {
    private double weight;
    public Cheese(String name, int price, int quantity, LocalDate expiryDate, double weight) {
        super.name = name;
        super.price = price;
        super.quantity = quantity;
        super.expirationDate = expiryDate;
        this.weight = weight;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

