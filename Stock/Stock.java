

import java.util.*;
import java.util.stream.Collectors;

public class Stock {
    private List<Toy> toys;

    public Stock() {
        this.toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        if (toy == null) {
            throw new IllegalArgumentException("Toy cannot be null.");
        }
        toys.add(toy);
    }

    public void viewStock() {
        if (toys.isEmpty()) {
            System.out.println("No toys in stock.");
        } else {
            System.out.println("Current stock of toys:");
            for (Toy toy : toys) {
                System.out.println(toy);
            }
        }
    }

    public void filterByCategory(String category) {
        List<Toy> filteredToys = toys.stream().filter(toy -> toy.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());

        if (filteredToys.isEmpty()) {
            System.out.println("No toys found in the category: " + category);
        } else {
            System.out.println("Toys in category '" + category + "':");
            filteredToys.forEach(System.out::println);
        }
    }

    public void listByPriceRange(double minPrice, double maxPrice) {
        List<Toy> filteredToys = toys.stream().filter(toy -> toy.getPrice() >= minPrice && toy.getPrice() <= maxPrice).collect(Collectors.toList());

        if (filteredToys.isEmpty()) {
            System.out.println("No toys found in the price range: " + minPrice + " - " + maxPrice);
        } else {
            System.out.println("Toys in price range " + minPrice + " - " + maxPrice + ":");
            filteredToys.forEach(System.out::println);
        }
    }

    public void sortByPrice() {
        toys.sort(Comparator.comparingDouble(Toy::getPrice));
        System.out.println("Toys sorted by price." + toys );
    }

    public void viewOlderThanOneYear() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Toy> oldToys = toys.stream().filter(toy -> toy.getPurchaseYear() < currentYear - 1).collect(Collectors.toList());

        if (oldToys.isEmpty()) {
            System.out.println("No old toys found.");
        } else {
            System.out.println("Old toys (purchased more than a year ago):");
            oldToys.forEach(System.out::println);
        }
    }

    public void groupByCategory() {
        Map<String, Long> categoryCount = toys.stream().collect(Collectors.groupingBy(Toy::getCategory, Collectors.counting()));

        if (categoryCount.isEmpty()) {
            System.out.println("No toys found to group.");
        } else {
            System.out.println("Toys grouped by category:");
            categoryCount.forEach((category, count) -> System.out.println(category + ": " + count));
        }
    }

    public void displayExpensiveAndCheapToys(String category) {
        List<Toy> filteredToys = toys.stream().filter(toy -> toy.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());

        if (filteredToys.isEmpty()) {
            System.out.println("No toys found in the category: " + category);
        } else {
            Optional<Toy> mostExpensive = filteredToys.stream().max(Comparator.comparingDouble(Toy::getPrice));
            Optional<Toy> leastExpensive = filteredToys.stream().min(Comparator.comparingDouble(Toy::getPrice));

            mostExpensive.ifPresent(toy -> System.out.println("Most expensive toy in category '" + category + "': " + toy));
            leastExpensive.ifPresent(toy -> System.out.println("Least expensive toy in category '" + category + "': " + toy));
        }
    }

    public void countToysByAgeGroup() {
        Map<String, Long> ageGroupCount = toys.stream().collect(Collectors.groupingBy(Toy::getAgeGroup, Collectors.counting()));

        if (ageGroupCount.isEmpty()) {
            System.out.println("No toys found to count by age group.");
        } else {
            System.out.println("Total number of toys by age group:");
            ageGroupCount.forEach((ageGroup, count) -> System.out.println(ageGroup + ": " + count));
        }
    }
}
