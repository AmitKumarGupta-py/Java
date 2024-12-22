package day1;

public class Students {
    public String name;
    public int id;
    public static int count1 = 0;

    public Students(String name)
    {
        count1++;
        this.id = count1;
        this.name = name;
    }

    public String toString()
    {
        return "Student roll no. : " + id + "name" + name;
    }

    public static void show()
    {
        System.out.println("total Students: " + count1);
    }

    public static void display(String...name)
    {
        int count = 0 ;
        for(String i:name)
        {
            count+=1;
            System.out.println(count + ":" + i);
        }

        
        
    }

    public static void main(String[] args) {
        Students.display("aaaa","asd","sadads");
        Students s1 = new Students("ssss");
        System.out.println(s1.toString());
        s1.show();
        Students s2 = new Students("s22");
        System.out.println(s2.toString());
        s2.show();
       
    }
}
