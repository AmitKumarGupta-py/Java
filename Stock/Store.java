import java.util.InputMismatchException;
import java.util.Scanner;

public class Store {
    private Stock stock;

    public Store() {
        stock = new Stock();
    }

    public static void main(String[] args) {
        Store manager = new Store();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Toy Store Manager!");

        do {
            System.out.println("\nAvailable Commands: "
                + "\n1. add_edu"
                + "\n2. add_batt"
                + "\n3. view"
                + "\n4. sort_price"
                + "\n5. group_by_category"
                + "\n6. view_older_than_one_year"
                + "\n7. filter_by_category"
                + "\n8. list_by_price_range"
                + "\n9. display_expensive_and_cheap_toys"
                + "\n10. count_toys_by_age_group"
                + "\n11. exit");
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "add_edu":
                    manager.addEducationalToy(scanner);
                    break;

                case "add_batt":
                    manager.addBatteryOperatedToy(scanner);
                    break;

                case "view":
                    manager.stock.viewStock();
                    break;

                case "sort_price":
                    manager.stock.sortByPrice();
                    break;

                case "group_by_category":
                    manager.stock.groupByCategory();
                    break;

                case "view_older_than_one_year":
                    manager.stock.viewOlderThanOneYear();
                    break;

                case "filter_by_category":
                    manager.filterByCategory(scanner);
                    break;

                case "list_by_price_range":
                    manager.listByPriceRange(scanner);
                    break;

                case "display_expensive_and_cheap_toys":
                    manager.displayExpensiveAndCheapToys(scanner);
                    break;

                case "count_toys_by_age_group":
                    manager.stock.countToysByAgeGroup();
                    break;

                case "exit":
                    System.out.print("Are you sure you want to exit? (yes/no): ");
                    String confirmation = scanner.nextLine();
                    if (confirmation.equalsIgnoreCase("yes")) {
                        System.out.println("Exiting the application.");
                    } else {
                        command = ""; 
                    }
                    break;

                default:
                    System.out.println("Invalid command. Try again.");
            }
        } while (!command.equalsIgnoreCase("exit"));

        scanner.close();
    }

    private void addEducationalToy(Scanner scanner) {
        try {
            String eduProductId = getInput(scanner, "Enter product ID: ");
            String eduName = getInput(scanner, "Enter toy name: ");
            double eduPrice = getDoubleInput(scanner, "Enter price: ");
            String eduAge = getInput(scanner, "Enter age (appropriate for): ");
            int eduPurchaseMonth = getIntInput(scanner, "Enter purchase month (1-12): ");
            int eduPurchaseYear = getIntInput(scanner, "Enter purchase year: ");
            String eduCategory = getInput(scanner, "Enter category: ");
            double eduRating = getDoubleInput(scanner, "Enter rating (0-5): ");
            String subject = getInput(scanner, "Enter subject: ");

            stock.addToy(new EducationalToy(eduProductId, eduName, eduPrice, eduAge, eduPurchaseMonth, eduPurchaseYear, eduCategory, eduRating, subject));
            System.out.println("Educational toy added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct type.");
            scanner.nextLine(); 
        }
    }

    private void addBatteryOperatedToy(Scanner scanner) {
        try {
            String battProductId = getInput(scanner, "Enter product ID: ");
            String battName = getInput(scanner, "Enter toy name: ");
            double battPrice = getDoubleInput(scanner, "Enter price: ");
            String battAge = getInput(scanner, "Enter age (appropriate for): ");
            int battPurchaseMonth = getIntInput(scanner, "Enter purchase month (1-12): ");
            int battPurchaseYear = getIntInput(scanner, "Enter purchase year: ");
            String battCategory = getInput(scanner, "Enter category: ");
            double battRating = getDoubleInput(scanner, "Enter rating (0-5): ");
            int batteryLife = getIntInput(scanner, "Enter battery life (hours): ");

            stock.addToy(new BatteryOperatedToy(battProductId, battName, battPrice, battAge, battPurchaseMonth, battPurchaseYear, battCategory, battRating, batteryLife));
            System.out.println("Battery operated toy added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct type.");
            scanner.nextLine(); 
        }
    }

    private void filterByCategory(Scanner scanner) {
        String category = getInput(scanner, "Enter category to filter by: ");
        stock.filterByCategory(category);
    }

    private void listByPriceRange(Scanner scanner) {
        double minPrice = getDoubleInput(scanner, "Enter minimum price: ");
        double maxPrice = getDoubleInput(scanner, "Enter maximum price: ");
        stock.listByPriceRange(minPrice, maxPrice);
    }

    private void displayExpensiveAndCheapToys(Scanner scanner) {
        String category = getInput(scanner, "Enter category to check: ");
        stock.displayExpensiveAndCheapToys(category);
    }

    private String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private double getDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = scanner.nextDouble();
                scanner.nextLine(); 
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); 
            }
        }
    }

    private int getIntInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine(); 
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); 
            }
        }
    }
}
