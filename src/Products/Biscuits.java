package Products;

import java.time.LocalDate;

public class Biscuits extends ExpirableProduct implements Shippable{
    private double weight;
    public Biscuits(String name, int price, int quantity, LocalDate expiryDate , double weight){
        super.name = name;
        super.price = price;
        super.quantity = quantity;
        super.expirationDate = expiryDate;
        this.weight = weight;
    }

        @Override
        public double getWeight() {
            return weight;
        }

}

