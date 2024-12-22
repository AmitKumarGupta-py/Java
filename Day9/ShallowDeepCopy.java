package Day9;

public class ShallowDeepCopy{
    
    static class Address {
        String city;

        Address(String city) {
            this.city = city;
        }
    }

    static class Person {
        String name;
        Address address; 

        Person(String name, Address address) {
            this.name = name;
            this.address = address;
        }

        
        public Person shallowCopy() {
            return new Person(this.name, this.address); 
        }

        
        public Person deepCopy() {
            return new Person(this.name, new Address(this.address.city)); 
        }
    }

    public static void main(String[] args) {
        
        Address address = new Address("New York");
        Person original = new Person("John", address);

        
        Person shallowCopy = original.shallowCopy();
        shallowCopy.address.city = "Los Angeles"; 

        System.out.println("Shallow Copy:");
        System.out.println("Original Person's City: " + original.address.city); 
        System.out.println("Shallow Copy Person's City: " + shallowCopy.address.city); 

        
        original.address.city = "New York";

        
        Person deepCopy = original.deepCopy();
        deepCopy.address.city = "Chicago"; 

        System.out.println("\nDeep Copy:");
        System.out.println("Original Person's City: " + original.address.city); 
        System.out.println("Deep Copy Person's City: " + deepCopy.address.city); 
    }
}
