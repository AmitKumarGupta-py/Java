package day1;

public class Account {

    private int accid;
    private String name;
    private static float intrate;


    static{
        //used to initialised the static variables
        System.out.println("Static Block 1");
        intrate = 6.5f;
    }

    static{
        //used to initialised the static variables
        System.out.println("Static Block 2");
        
    }
    public Account()
    {
        //accid = 10000;
       // name = "aaaa";
        this(100000,"aaaa");

    }

    public Account(int accid,String name)
    {
        this.accid = accid;
        this.name = name;
    }

    

    public static void displayInterestRate()
    {
        System.out.println("Current interest rate for account: " + intrate);
    }
    

    
}
