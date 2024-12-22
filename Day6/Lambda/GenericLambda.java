package Lambda;



public class GenericLambda {
    public static <T> T operateOnData(Function<T> f,T data)
    {
        return f.apply(data);
    }

    public static void main(String[] args) {
        String subString = operateOnData((s) -> s.substring(3), "Java 11");
        System.out.println(subString);

        Integer square = operateOnData((n)-> n*n, 24);
        System.out.println(square);

        

    }
    
}
