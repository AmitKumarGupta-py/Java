package interface_day4;

public class Printer {

    public void printData(Printable p)
    {
        p.print();
    }

    public static void main(String[] args)
    {
        Printer p = new Printer();
        Book b = new Book("Head first java", 900);
        p.printData(b);

        SalariedEmployee e = new SalariedEmployee(21,"aaa",9000);
        p.printData(e);



    }
    
}
