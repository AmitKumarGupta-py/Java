package Day5;

import Day5.EmptyStringException;

public class StringMethods {

    public static String convertToLower(String s) throws EmptyStringException
    {
        if(s=="")
            throw new EmptyStringException("String is empty");
        else
            return s.toLowerCase();
    }

    public static void main(String[] args) {
        
        //String s = " ajava is an oo langauge";

        String s1 = "";
        try{
            String lower = convertToLower(s1);
            System.out.println(lower);
        }
        catch(Day5.EmptyStringException e)
        {
            System.out.println(e.getMessage());
        }
    }

    

}
