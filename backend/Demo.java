package backend;

public class Demo {
    public static void main(String[] args) {
        // create a type of shop and order some coffee from both
        CoffeeShop RegShop = new RegStyleCoffeeShop();
        CoffeeShop DecafShop = new DecafStyleCoffeeShop();

        System.out.println("Regular Store Order:");
        RegShop.orderCoffee("espresso");

        System.out.println("\nDecaf Store Order:");
        DecafShop.orderCoffee("espresso");
    }
}
