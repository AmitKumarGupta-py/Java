package day4;
public abstract class Dessert extends DessertStore {
    protected String items;
    protected int quantity;

    public Dessert(String name, int price, double total, String items, int quantity) {
        super(name, price, total);
        this.items = items;
        this.quantity = quantity;
    }

    public abstract void selectDessert();

    public abstract double calculateTotalPrice();
      

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Items: " + items);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + calculateTotalPrice());
    }
}
