package Day6;

public class Stat<T extends Number> {
    T[] num;
    public void setValues(T[] num)
    {
        this.num = num;
    }

    public double getAverage()
    {
        double sum =0.0;
        for(int i= 0; i<num.length;i++)
        {
            sum+=num[i].doubleValue();
        }
        return sum/num.length;
    }

    public static void main(String[] args) {
         Integer[] arr = {12,14,16,134,454};
         Stat<Integer> stat1 = new Stat<>();
         stat1.setValues(arr);
         System.out.println(stat1.getAverage());


         Double[] arr1 = {12.5,14.56,16.567,134.43,454.67};
         Stat<Double> stat2 = new Stat<>();
         stat2.setValues(arr1);
         System.out.println(stat2.getAverage());

    }
    
}
