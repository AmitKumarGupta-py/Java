package Stock;

public class BatteryOperatedToy extends Toy {
    private int batteryLife; 

    public BatteryOperatedToy(String productId, String name, double price, String ageGroup, 
                              int purchaseMonth, int purchaseYear, String category, 
                              double rating, int batteryLife) 
    {
        super(productId, name, price, ageGroup, purchaseMonth, purchaseYear, category, rating);
        if (batteryLife < 0) {
            throw new IllegalArgumentException("Battery life must be a non-negative integer.");
        }
        this.batteryLife = batteryLife;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        if (batteryLife < 0) {
            throw new IllegalArgumentException("Battery life must be a non-negative integer.");
        }
        this.batteryLife = batteryLife;
    }

    @Override
    public String getToyType() {
        return "BatteryOperatedToy";
    }

    @Override
    public String toString() {
        return "BatteryOperatedToy{" + super.toString() + ", batteryLife=" + batteryLife + " hours" + '}';
    }
}
