package Day10;

import java.lang.reflect.Array;

public class DemoArray {
    public static void main(String[] args) {
        String [] args = (String [] ) Array.newInstance();
        args[0] = "Hello";
        System.out.println(args[0]);    
        
    
}
