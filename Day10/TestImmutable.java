package Day10;

public class TestImmutable {

    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<String>();
        colors.add("White");
        colors.add("Black");

        Date mdate = new Date(1,1,2020);
        Car c = new Car("aaa","bbbb",mdate,colors);
        System.out.println(c);
        colors.add("Red");
        mdate.setDay(12);
        System.out.println(c);
        System.out.println(c.getMandate());
        System.out.println(c.getColors());
        }
    
}
