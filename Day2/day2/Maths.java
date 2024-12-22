package day2;

import java.util.Date;
import java.util.Arrays;

public class Maths {
/*Parameters in java are passed by value: 
only a copy of variable data is passed from calling
 * method , not the actual data :
 * when an array/reference variable is passed it passes copy of 
 * reference to the called method not the actual object
 */


    public static int increment(int num)
    {
        num = num+1;
        return num;
    }
    public static void incrementDate(NewDate d)
    {
        int day = d.getDay();
        d.setDay(day+1);
    }

    public static void swapDates(Date d1, Date d2)
    {
        Date temp = null;
        temp = d1;
        d1 = d2;
        d2 = temp;
    }

    public static void sortArray(int [] arr)
    {
        int n = arr.length;
        for(int i=0;i<n;i++)
    {
        for(int j=0;j<n-1;j++)
        {
            if(arr[j]> arr[j+1])
            {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
    }
    public static void main(String[] args) {
        
        int n = 10;
        System.out.println("Before Increment: "+ n);
        n = increment(n);
        System.out.println("After Increment: " + n);
        
        NewDate d = new NewDate();
        d.setDay(23);
        d.setMonth("Jan");
        d.setYear(2000);

        System.out.println("Before Increment : " + d);
        incrementDate(d);
        System.out.println("After Increment : " + d);

        Date dt1 = new Date(4,"Dec",1900);
        Date dt2 = new Date(5,"Dec",1900);

        System.out.println("Before Swap d1 : " + dt1 + "d2" + dt2);
        swapDates(dt1,dt2);
        System.out.println("After Swap d1 : " + dt1 + "d2" + dt2);
        
        int arr[] = {12,34,10,45,67};
        sortArray(arr);

        System.out.println("After Sorting: " + Arrays.toString(arr));
        
        
    }
    
}
