package day1;

public class TestAccounts {
    public static void main(String[] args) {
        //If only parameterised contructor is provided
        //then JVM will not provide default constructor

        Account acc = new Account();//default constructor
        Account acc1 = new Account(1213213,"cccc"); //parameterised
        
        System.out.println("In main");

        //static methods should be called as classname.methodname
        Account.displayInterestRate();
    }
    
}
