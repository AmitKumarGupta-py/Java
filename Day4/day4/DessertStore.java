package day4;


public abstract class DessertStore {
    protected String name;
    protected double total;

    public DessertStore(String name) {
        this.name = name;
        this.total = 0;
    }

    public void displayInfo() {
        System.out.println("Dessert Store: " + name);
        System.out.println("Total Revenue: " + total);
    }
}

