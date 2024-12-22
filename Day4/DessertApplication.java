package day4;

public class DessertApplication {
    public static void main(String[] args) {
        
        Icecream icecream = new Icecream("Ice Cream ", 50, 0, "Quantity", 2, "Chocolate");
        Candies candies = new Candies("Candy ", 20, 0, "Quantity", 10, "Gummy");
        Cookies cookies = new Cookies("Cookie ", 30, 0, "Quantity", 5, "Chocolate Chip");

       
        Cart cart = new Cart("Dessert cart");

        
        cart.addDessert(icecream);
        cart.addDessert(candies);
        cart.addDessert(cookies);

        
        cart.displayCart();
    }
}
