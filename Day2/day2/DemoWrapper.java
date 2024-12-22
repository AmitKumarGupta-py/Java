package day2;

public class DemoWrapper {
    public static void main(String[] args) {
        
        int i =5;
        Integer j =Integer.valueOf(i);//primitive to wrapper
        System.out.println(j);

        int k = j.intValue();//Wrapper to primitive

        //Auto Boxing 
        int a= 12;
        Integer b = a;
        
        //Auto Unboxing 

        int c = b;

        //parsing 
        int x = Integer.parseInt("30");
        Integer y = Integer.valueOf("40");
    }
    
}
