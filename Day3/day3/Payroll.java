package Day3.day3;

public class Payroll {

    public void displayGross(Employee e)
    {
        System.out.println("Gross Salary: " + e.calculateGross());
    }

    public void displayNet(SalariedEmployee e)
    {
        System.out.println("Net Salary: " + e.calculateNet());
    }
    
}
