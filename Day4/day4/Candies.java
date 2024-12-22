package day4;
public class Candies extends Dessert {
    private String type;

    public Candies(String name, int price, int quantity, String type) {
        super(name, price, quantity);
        this.type = type;
    }

    @Override
    public double calculateTotalPrice() {
        return (quantity * price) / 1000; 
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + type);
    }
}
