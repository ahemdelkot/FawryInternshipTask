import Products.Biscuits;
import Products.Cheese;
import Products.TV;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
       Customer c1 = new Customer("Ahmed" , 1000000);
       Cart cart = new Cart();
       Cheese cheese = new Cheese("Cheddar", 200, 2, LocalDate.of(2026, 12, 31), 400);
       Biscuits biscuits = new Biscuits("Oreo", 50, 5, LocalDate.of(2026, 1, 15) , 150);
       TV tv = new TV("Samsung", 5000, 1, 5000);

       cart.addItem(cheese , 1);
       cart.addItem(biscuits , 1);
       cart.addItem(tv , 1);

       CheckOut checkOut = new CheckOut();
       checkOut.CheckOut(c1 , cart);


    }
}
