package ToyCompany;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Stock {
    private List<Toy> toys;

    public Stock() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
        System.out.println("Toy added: " + toy.getName());
    }

    public boolean removeToy(String productId) {
        boolean removed = toys.removeIf(toy -> toy.getProductId().equalsIgnoreCase(productId));
        if (removed) {
            System.out.println("Removed toy with Product ID: " + productId);
        } else {
            System.out.println("No toy found with Product ID: " + productId);
        }
        return removed;
    }

    public void viewStock() {
        if (toys.isEmpty()) {
            System.out.println("No toys in stock.");
            return;
        }
        System.out.println("Current Stock:");
        for (Toy toy : toys) {
            System.out.println(toy);
        }
    }

    public void sortByPrice() {
        Collections.sort(toys, new PriceComparator());
        System.out.println("Toys sorted by price:");
        viewStock();
    }

    public void sortByRating() {
        Collections.sort(toys, new RatingComparator());
        System.out.println("Toys sorted by rating:");
        viewStock();
    }

    public void sortByProductId() {
        Collections.sort(toys, new ProductIdComparator());
        System.out.println("Toys sorted by Product ID:");
        viewStock();
    }
    
    
    public void viewOlderThanOneYear() {
        int currentYear = java.time.Year.now().getValue();
        List<Toy> olderToys = new ArrayList<>();

        for (Toy toy : toys) {
            if (toy.getPurchaseYear() < currentYear - 1) {
                olderToys.add(toy);
            }
        }

        if (olderToys.isEmpty()) {
            System.out.println("No products older than one year.");
        } else {
            System.out.println("Products older than one year:");
            for (Toy toy : olderToys) {
                System.out.println(toy);
            }
        }
    }

    public void searchByProductId(Scanner scanner) {
        System.out.print("Enter product ID to search: ");
        String productIdToSearch = scanner.nextLine();

        Toy dummyToy = new Toy(productIdToSearch, "", 0, "", 0, 0, "", 0) {
            @Override
            public String getToyType() {
                return "Dummy Toy for searching";
            }
        };

        int index = Collections.binarySearch(toys, dummyToy, new ProductIdComparator());

        if (index >= 0) {
            System.out.println("Toy found: " + toys.get(index));
        } else {
            System.out.println("Toy not found.");
        }
    }

    public void groupByCategory() { 
        if (toys.isEmpty()) {
            System.out.println("No toys in stock.");
            return;
        }

        Map<String, List<Toy>> categoryMap = new HashMap<>();
        for (Toy toy : toys) {
            categoryMap.computeIfAbsent(toy.getCategory(), k -> new ArrayList<>()).add(toy);
        }

        System.out.println("Toys grouped by category:");
        for (Map.Entry<String, List<Toy>> entry : categoryMap.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (Toy toy : entry.getValue()) {
                System.out.println(" - " + toy);
            }
        }
    }
}
