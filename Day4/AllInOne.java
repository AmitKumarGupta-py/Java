package day4;

import java.util.ArrayList;
import java.util.List;

public abstract class DessertStore {
    protected String name;
    protected double total;

    public DessertStore(String name) {
        this.name = name;
        this.total = 0;
    }

    public void displayInfo() {
        System.out.println("Dessert Store: " + name);
        System.out.println("Total Revenue: " + total);
    }
}

public abstract class Dessert {
    protected String name;
    protected int price;
    protected int quantity;

    public Dessert(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();
    
    public void displayInfo() {
        System.out.println("Dessert: " + name);
        System.out.println("Price per unit: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + calculateTotalPrice());
    }
}

public class Cart extends DessertStore {
    private List<Dessert> desserts;

    public Cart(String name) {
        super(name);
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

public class Cookies extends Dessert {
    private String type;

    public Cookies(String name, int price, int quantity, String type) {
        super(name, price, quantity);
        this.type = type;
    }

    @Override
    public double calculateTotalPrice() {
        return (quantity * price) / 12; // Price per dozen
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + type);
    }
}

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

public class Candies extends Dessert {
    private String type;

    public Candies(String name, int price, int quantity, String type) {
        super(name, price, quantity);
        this.type = type;
    }

    @Override
    public double calculateTotalPrice() {
        return (quantity * price) / 1000; // Price per gram
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + type);
    }
}

public class DessertApplication {
    public static void main(String[] args) {
        Icecream icecream = new Icecream("Ice Cream", 50, 2, "Chocolate");
        Candies candies = new Candies("Candy", 20, 10, "Gummy");
        Cookies cookies = new Cookies("Cookie", 30, 5, "Chocolate Chip");

        Cart cart = new Cart("Dessert cart");

        cart.addDessert(icecream);
        cart.addDessert(candies);
        cart.addDessert(cookies);

        cart.displayCart();
    }
}
