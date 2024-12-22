package interface_day4;

public class Book implements Printable,Writable 
{
    private String title;
    private int price;

    public Book(String title,int price)
    {
        super();
        this.title = title;
        this.price = price;
    }

    @Override
    public void write()
    {
        System.out.println("Writting a book");
    }

    @Override
    public void print()
    {
        System.out.println("\nPrinting a book");
    }

    @Override
    public void foo()
    {
        Printable.super.foo();
    }
    
    
    @Override
    public void foo()
    {
        Writable.super.foo();
    }
}
