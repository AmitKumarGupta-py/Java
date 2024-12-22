package day2;
import day2.Date;
public class Car {
    private String make;
    private String model;
    private Date purchasedate;

    public Car(String make, String model, Date purchaseDate) {
        this.make = make;
        this.model = model;
        this.purchasedate = purchasedate;

    }

    public String toString()
    {
        return "Car Make- "+ make + ",Model- "+ model +",Purchase Date: " + purchasedate ;
    }
    
    public static void main(String[] args) {
        
        //Date d1 = new Date();
        
        Car car = new Car("Honda","City", new Date(1,"Mar",2022));
        System.out.println(car);
    }
}
