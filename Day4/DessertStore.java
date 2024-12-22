package day4;


public abstract class DessertStore {
    protected String name;
    protected int price;
    protected double total;

    public DessertStore(String name, int price, double total) {
        this.name = name;
        this.price = price;
        this.total = total;
    }

    public abstract void selectDessert();

    public void displayInfo() {
        System.out.println("Dessert Store: " + name);
        System.out.println("Price: " + price);
        System.out.println("Total Revenue: " + total);
    }
}
