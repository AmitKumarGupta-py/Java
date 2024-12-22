package day4;


import java.util.Scanner;

public class DessertApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart("Dessert cart");
        boolean running = true;

        while (running) {
            System.out.println("\n--- Dessert Store Menu ---");
            System.out.println("1. Add Ice Cream");
            System.out.println("2. Add Cookies");
            System.out.println("3. Add Candies");
            System.out.println("4. View Cart");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Ice Cream Flavor: ");
                    String flavor = scanner.next();
                    System.out.print("Enter Price: ");
                    int iceCreamPrice = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int iceCreamQuantity = scanner.nextInt();
                    cart.addDessert(new Icecream("Ice Cream", iceCreamPrice, iceCreamQuantity, flavor));
                    break;

                case 2:
                    System.out.print("Enter Cookie Type: ");
                    String cookieType = scanner.next();
                    System.out.print("Enter Price: ");
                    int cookiePrice = scanner.nextInt();
                    System.out.print("Enter Quantity (dozens): ");
                    int cookieQuantity = scanner.nextInt();
                    cart.addDessert(new Cookies("Cookies", cookiePrice, cookieQuantity, cookieType));
                    break;

                case 3:
                    System.out.print("Enter Candy Type: ");
                    String candyType = scanner.next();
                    System.out.print("Enter Price: ");
                    int candyPrice = scanner.nextInt();
                    System.out.print("Enter Quantity (grams): ");
                    int candyQuantity = scanner.nextInt();
                    cart.addDessert(new Candies("Candies", candyPrice, candyQuantity, candyType));
                    break;

                case 4:
                    cart.displayCart();
                    break;

                case 5:
                    running = false;
                    System.out.println("Thank you for visiting the Dessert Store!");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        scanner.close();
    }
}
