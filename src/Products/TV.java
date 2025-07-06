package Products;

public class TV extends Product implements Shippable{
    private int weight;

    public TV(String name, int price, int quantity, int weight) {
        super.name = name;
        super.price = price;
        super.quantity = quantity;
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
