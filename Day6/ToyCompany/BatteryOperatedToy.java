package ToyCompany;

public class BatteryOperatedToy extends Toy {
    private int batteryLife; 

    public BatteryOperatedToy(String productId, String name, double price, String age, int purchaseMonth, int purchaseYear, String category, double rating, int batteryLife) {
        super(productId, name, price, age, purchaseMonth, purchaseYear, category, rating);
        this.batteryLife = batteryLife;
    }

    @Override
    public String getToyType() {
        return "BatteryOperatedToy";
    }

    @Override
    public String toString() {
        return super.toString() + ", batteryLife=" + batteryLife + " hours" + '}';
    }
}
