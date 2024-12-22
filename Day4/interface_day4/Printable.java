package interface_day4;

public interface Printable {
    void print();
    default void foo()
    {
        System.out.println("This is default Functionality");
    }

    
} 