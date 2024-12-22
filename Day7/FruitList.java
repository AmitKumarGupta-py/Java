package day7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.stream.Collectors;

public class FruitList {
    public static void main(String[] args) {
        
        List<String> lst = new ArrayList<>();
        lst.add("Mango");
        lst.add("orange");
        lst.add("Grapes");
        lst.add("apple");
        lst.add("Banana");
        lst.add("strawberry");
        lst.add("Watermelon");

        
        for (String fruit : lst) {
            System.out.println(fruit);
        }

        List<String> upperCaseFruits = lst.stream().map(String::toUpperCase).collect(Collectors.toList());

        
        System.out.println("Uppercase Fruits:\n");
        upperCaseFruits.forEach(System.out::println);

        
        List<String> lowerCaseFruits = lst.stream().map(String::toLowerCase).collect(Collectors.toList());

        
        System.out.println("\nLowercase Fruits:\n");
        lowerCaseFruits.forEach(System.out::println);


        List<String> ascendingOrder = lst.stream().filter(n-> n.compareTo("n")< 0 ).sorted(String::compareTo).collect(Collectors.toList());
        System.out.println("\nAscending order:\n ");
        ascendingOrder.forEach(System.out::println);

        List<String> descendingOrder = lst.stream().filter(n-> n.compareTo("n")< 0 ).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("\nDescending order:\n "); 
        descendingOrder.forEach(System.out::println);
       
        List<String> uppercaseList = lst.stream().filter(n-> Character.isUpperCase(n.charAt(0)) ).sorted(String::compareTo).collect(Collectors.toList());
        System.out.println("\nUppercase list order:\n "); 
        uppercaseList.forEach(System.out::println);


        List<String> filteredAndSortedFruits = lst.stream().filter(n -> n.length() <= 6).sorted(Comparator.reverseOrder()).collect(Collectors.toList()); 

        System.out.println("\nlist of fruits with 6 alphabets or less in descending order:\n "); 
        filteredAndSortedFruits.forEach(System.out::println);

        

    }
}
