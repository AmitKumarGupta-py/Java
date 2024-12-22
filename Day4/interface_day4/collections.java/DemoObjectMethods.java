package interface_day4.collections.java;

import interface_day4.Car;

public class DemoObjectMethods {
    public static void main(String[] args) throws CloneNotSupportedException{
        
        Car car1 = new Car("aaa","ssss",3534);
        Car car1 = new Car("aaa","ssss",3534);

        System.out.println(car1.equals(car2));

        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());

        Car car3 = (Car)car1.clone();
        car1.setPrice(8000);
        car1.setModel("ccc");
        System.out.println(car3);
    }
    
}
