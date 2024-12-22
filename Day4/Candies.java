package day4;

public class Candies extends Dessert {
    private String type;

    public Candies(String name, int price, double total, String items, int quantity, String type) {
        super(name, price, total, items, quantity);
        this.type = type;
    }

    @Override
    public void selectDessert() {
        System.out.println("Quantity in grams:  " + quantity + " " + type + " candies.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + type);
    }

    @Override
    public double calculateTotalPrice() {
        // TODO Auto-generated method stub
        return (quantity * price)/1000;

}