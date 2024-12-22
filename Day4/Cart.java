package day4;
import java.util.ArrayList;
import java.util.List;

public class Cart extends DessertStore {
    private List<Dessert> desserts;

    public Cart(String name) {
        super(name, 0, 0);
        this.desserts = new ArrayList<>();
    }

    public void addDessert(Dessert dessert) {
        desserts.add(dessert);
        total += dessert.calculateTotalPrice();
    }

    public void displayCart() {
        System.out.println("Cart: " + name);
        System.out.println("Desserts in the cart:");
        for (Dessert dessert : desserts) {
            dessert.displayInfo();
        }
        System.out.println("Total Price: " + total);
    }

    
}
