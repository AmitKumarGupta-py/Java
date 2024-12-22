package interface_day4;

public interface Writable {
    void write();
    default void foo()
    {
        System.out.println("This is default Functionality");
    }
}
