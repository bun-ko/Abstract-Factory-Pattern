package backend;
public abstract class Coffee {
    // abstract class coffee for concrete classes
    public void brew() {
        System.out.println("brewing " + this.getClass().getSimpleName());
    }
    
    public void pour() {
        System.out.println("pouring " + this.getClass().getSimpleName());
    }
    
    public void addCondiments() {
        System.out.println("adding condiments to " + this.getClass().getSimpleName());
    }
    
    public void serve() {
        System.out.println("serving " + this.getClass().getSimpleName());
    }
}
