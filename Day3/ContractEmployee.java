package day3;

import day3.Employee;

public class ContractEmployee extends Employee {
   protected double pay;
   protected double hrs;

    public ContractEmployee(int empid, String name,double pay,double hrs)
    {
        super(empid, name);//explicitly calling super class constructor
        this.pay = pay;
        this.hrs = hrs;
        
    }

    
    @Override
    public double calculateGross()
    {
       
        return pay * hrs;
    }
}
