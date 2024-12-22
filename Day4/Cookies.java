package day4;
public class Cookies extends Dessert {
    private String type;

    public Cookies(String name, int price, double total, String items, int quantity, String type) {
        super(name, price, total, items, quantity);
        this.type = type;
    }

    @Override
    public void selectDessert() {
        System.out.println("Quantity in dozen " + quantity + " " + type + " cookies.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + type);
    }

    @Override
    public double calculateTotalPrice() {
        // TODO Auto-generated method stub
        return (quantity * price)/12;


        
    }
}