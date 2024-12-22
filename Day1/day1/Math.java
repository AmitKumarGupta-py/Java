package day1;
public class Math{

    public static void factorial(int data){
        int fact = 1;
        if (data == 0){
            System.out.println("Factorial is "+ fact);
        }
        else if(data == 1){
            System.out.println("Factorial is "+ fact);
        
        }

        else{
            while(data > 1)
            {
                fact = fact * data--;
            }
        }
        System.out.println("Factorial is " + fact);
    }

    public  static boolean isPrime(int data){
        for(int i=2;i<data;i++)
    {
        if(data % i == 0){
            return false;
        
        }
    }
    return true;
    }
    
    public static void main(String[] args){
           
            Math.factorial(5);
            
            System.out.println(Math.isPrime(34));
            
    
        }

    
}
