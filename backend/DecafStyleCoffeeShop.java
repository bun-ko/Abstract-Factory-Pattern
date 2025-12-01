package backend;
public class DecafStyleCoffeeShop extends CoffeeShop {
    // different coffee orders
    @Override
    protected Coffee createCoffee(String type) {
        switch (type.toLowerCase()) {
            case "darkroast":
                return new DecafStyleDarkRoast();
            case "espresso":
                return new DecafStyleEspresso();
            case "latte":
                return new DecafStyleLatte();
            case "cappuccino":
                return new DecafStyleCappuccino();
            default:
                System.out.println("Unknown coffee type.");
                return null;
        }
    }
}
