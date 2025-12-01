package backend;
public abstract class CoffeeShop {
    public Coffee orderCoffee(String type) {
        // process order
        Coffee coffee = createCoffee(type);
        
        if (coffee != null) {
            coffee.brew();
            coffee.pour();
            coffee.addCondiments();
            coffee.serve();
        }
        
        return coffee;
    }
    
    // Factory method to create pizza, implemented by subclasses
    protected abstract Coffee createCoffee(String type);
}
