package day4;
public class Cookies extends Dessert {
    private String type;

    public Cookies(String name, int price, int quantity, String type) {
        super(name, price, quantity);
        this.type = type;
    }

    @Override
    public double calculateTotalPrice() {
        return (quantity * price) / 12; 
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + type);
    }
}
