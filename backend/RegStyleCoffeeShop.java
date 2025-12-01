package backend;
class RegStyleCoffeeShop extends CoffeeShop {
    // different coffee orders
    @Override
    protected Coffee createCoffee(String type) {
        switch (type.toLowerCase()) {
            case "darkroast":
                return new RegStyleDarkRoast();
            case "espresso":
                return new RegStyleEspresso();
            case "latte":
                return new RegStyleLatte();
            case "cappuccino":
                return new RegStyleCappuccino();
            default:
                System.out.println("Unknown coffee type.");
                return null;
        }
    }
}