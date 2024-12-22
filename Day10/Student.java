package Day10;

public class Student {
    private String name;
    private int rollNo;
    public Student()
    {
        rollNo = 100;
        name = "ppp";
    }   

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    private void privateeMethod()
    {
        System.out.println("This is private method");
    }
    public static void staticMethod()
    {
        System.out.println("This is static method");
    }
    
    @CreatedBy(priority = 1,createdBy = "aaa")
    public void displayData()
    {
        System.out.println("Name: " + name + ", Roll No: " + rollNo);
    }
    public void methodWithParam(int rollNo)
{
    this.rollNo = rollNo;
    System.out.println("Roll No: " + rollNo);
}
}
