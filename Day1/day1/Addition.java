package day1;
public class Addition {
    
    public static void add(int a,int b)
    {
            System.out.println("Sum = " + (a+b));
    }
    public static void add(int a,float b)
    {
        System.out.println("Sum = " + (a+b));
    } 

    public static void  add(float a, int b){
        System.out.println("Sum = " + (a+b));
    }
    public static void  add(float a, float b){
        System.out.println("Sum = " + (a+b));
    }

    public static void  add(int...num){
        int res = 0;
        //for(int i=0;i < num.length;i++)
        //{
         //   res+=num[i];
        //}
        //for each loop
        for(int i:num)
        {
            res+=i;
        }

        System.out.println("Sum = " + res);
    }
    public static void main(String[] args) {
        
        Addition.add(10,12);
        Addition.add(12, 16.0f);
        Addition.add(12.34f, 23);
        Addition.add(12.43f, 54.60f);
        Addition.add(1,223,34,2,3,4,5,6);
        Addition.add(1,2,3,4,5,6);

    }
}
