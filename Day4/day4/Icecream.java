package day4;
public class Icecream extends Dessert {
    private String flavor;

    public Icecream(String name, int price, int quantity, String flavor) {
        super(name, price, quantity);
        this.flavor = flavor;
    }

    @Override
    public double calculateTotalPrice() {
        return quantity * price; // Price per piece
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Flavor: " + flavor);
    }
}