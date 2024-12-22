package ToyCompany;

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

        do {
            System.out.println("\nCommands: add_edu, add_batt, remove, view, sort_price, sort_rating, sort_id, search_by_id, group_by_category, view_older_than_one_year, exit");
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "add_edu":
                    manager.addEducationalToy(scanner);
                    break;

                case "add_batt":
                    manager.addBatteryOperatedToy(scanner);
                    break;

                case "remove":
                    manager.removeToy(scanner);
                    break;

                case "view":
                    manager.stock.viewStock();
                    break;

                case "sort_price":
                    manager.stock.sortByPrice();
                    break;

                case "sort_rating":
                    manager.stock.sortByRating();
                    break;

                case "sort_id":
                    manager.stock.sortByProductId();
                    break;

                case "search_by_id":
                    manager.stock.searchByProductId(scanner);
                    break;

                case "group_by_category":
                    manager.stock.groupByCategory();
                    break;

                case "view_older_than_one_year":
                    manager.stock.viewOlderThanOneYear();
                    break;

                case "exit":
                    System.out.println("Exiting the application.");
                    break;

                default:
                    System.out.println("Invalid command. Try again.");
            }
        } while (!command.equalsIgnoreCase("exit"));

        scanner.close();
    }

    private void addEducationalToy(Scanner scanner) {
        try {
            System.out.print("Enter product ID: ");
            String eduProductId = scanner.nextLine();
            System.out.print("Enter toy name: ");
            String eduName = scanner.nextLine();
            System.out.print("Enter price: ");
            double eduPrice = scanner.nextDouble();
            System.out.print("Enter age (appropriate for): ");
            scanner.nextLine();  
            String eduAge = scanner.nextLine();
            System.out.print("Enter purchase month (1-12): ");
            int eduPurchaseMonth = scanner.nextInt();
            System.out.print("Enter purchase year: ");
            int eduPurchaseYear = scanner.nextInt();
            scanner.nextLine();  
            System.out.print("Enter category: ");
            String eduCategory = scanner.nextLine();
            System.out.print("Enter rating (0-5): ");
            double eduRating = scanner.nextDouble();
            scanner.nextLine();  
            System.out.print("Enter subject: ");
            String subject = scanner.nextLine();

            stock.addToy(new EducationalToy(eduProductId, eduName, eduPrice, eduAge, eduPurchaseMonth, eduPurchaseYear, eduCategory, eduRating, subject));
            System.out.println("Educational toy added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); 
        }
    }

    private void addBatteryOperatedToy(Scanner scanner) {
        try {
            System.out.print("Enter product ID: ");
            String battProductId = scanner.nextLine();
            System.out.print("Enter toy name: ");
            String battName = scanner.nextLine();
            System.out.print("Enter price: ");
            double battPrice = scanner.nextDouble();
            System.out.print("Enter age (appropriate for): ");
            scanner.nextLine();  
            String battAge = scanner.nextLine();
            System.out.print("Enter purchase month (1-12): ");
            int battPurchaseMonth = scanner.nextInt();
            System.out.print("Enter purchase year: ");
            int battPurchaseYear = scanner.nextInt();
            scanner.nextLine();  
            System.out.print("Enter category: ");
            String battCategory = scanner.nextLine();
            System.out.print("Enter rating (0-5): ");
            double battRating = scanner.nextDouble();
            System.out.print("Enter battery life (hours): ");
            int batteryLife = scanner.nextInt();
            scanner.nextLine();  

            stock.addToy(new BatteryOperatedToy(battProductId, battName, battPrice, battAge, battPurchaseMonth, battPurchaseYear, battCategory, battRating, batteryLife));
            System.out.println("Battery operated toy added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); 
        }
    }

    private void removeToy(Scanner scanner) {
        System.out.print("Enter product ID to remove: ");
        String removeId = scanner.nextLine();
        if (!stock.removeToy(removeId)) {
            System.out.println("No toy found with the given Product ID.");
        }
    }
}
