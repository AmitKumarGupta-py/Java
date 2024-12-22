package Store_Dessert;
import java.util.Scanner;

class Store {
    private Cart cart;
    private final Candy candy;
    private final Cookie cookie;
    private final IceCream iceCream;

    public Store() {
        cart = new Cart();
        candy = new Candy(10.0); 
        cookie = new Cookie(5.0);
        iceCream = new IceCream(2.0); 
    }

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Candy (per kg) - 10.00");
        System.out.println("2. Cookies (per dozen) - 5.00");
        System.out.println("3. Ice Cream (per piece) - 2.00");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        displayMenu();

        while (true) {
            System.out.print("Select type of dessert (candy/cookie/ice_cream) or 'exit' to finish: ");
            String dessertType = scanner.nextLine().trim().toLowerCase();

            if (dessertType.equals("exit")) {
                break;
            }

            Dessert selectedDessert;
            switch (dessertType) {
                case "candy":
                    selectedDessert = candy;
                    break;
                case "cookie":
                    selectedDessert = cookie;
                    break;
                case "ice_cream":
                    selectedDessert = iceCream;
                    break;
                default:
                    System.out.println("Invalid dessert type. Please try again.");
                    continue;
            }

            System.out.print("Enter quantity for " + dessertType + ": ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); 
            cart.addToCart(selectedDessert, quantity);
        }

        cart.printReceipt();
        scanner.close();
    }
}

  