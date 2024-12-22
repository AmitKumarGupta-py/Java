package day4;

public abstract class Dessert extends DessertStore{
    protected String name;
    protected int price;
    protected int quantity;

    public Dessert(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void displayInfo() {
        System.out.println("Dessert: " + name);
        System.out.println("Price per unit: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + calculateTotalPrice());
    }
}


