package day3;

import day3.SalariedEmployee;

public class Manager extends SalariedEmployee{
    protected double allowance;

    public Manager(int empid, String name,double basic,double allowance)
    {
        super(empid, name,basic);//explicitly calling super class constructor
        this.allowance = allowance;
        
    }

    @Override
    public double calculateGross()
    {
        //double hra = basic * 0.4;
       // double da =basic * 0.12;
       // return basic + hra + da + allowance;
    	
    	return super.calculateGross() + allowance;
    }
    
    public void displayAllowance()
    {
    	System.out.println("Allowance: " + allowance);
    }
    
}
