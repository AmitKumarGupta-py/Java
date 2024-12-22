package day4;

public class Icecream extends Dessert {
    private String flavor;

    public Icecream(String name, int price, double total, String items, int quantity, String flavor) {
        super(name, price, total, items, quantity);
        this.flavor = flavor;
    }

    @Override
    public void selectDessert() {
        System.out.println("Quantity per piece:  " + quantity + " " + flavor + " ice cream cones.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Flavor: " + flavor);
    }

    @Override
    public double calculateTotalPrice() {
        // TODO Auto-generated method stub
        return (quantity * price);


}
