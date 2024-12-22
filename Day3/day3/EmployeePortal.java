package Day3.day3;

public class EmployeePortal {

    public static void main(String[] args)
    {
        Payroll payroll = new Payroll();

        SalariedEmployee se = new SalariedEmployee(322,"asas",87000);
        payroll.displayGross(se);
        payroll.displayNet(se);

        Employee [] emps = new Employee[2];
        emps[0] = new SalariedEmployee(434,"dsss",54000);//up casting
        emps[1] = new Manager(465,"hghf",90000,10000);

        /*
         *calculateGross() is defined in Employee and overriden in Salaried Employee
         
         * hence can be invokeed using Employee reference emps[0]
         */

         payroll.displayGross(emp[0]);

         /*
          * To invoke calculateNet() which is defined in SalariedEmployee
          the employee refrence must be down casted to salariedEmployee
          */

          SalariedEmployee ss = (SalariedEmployee)emps[0];//down casting

          payroll.displayNet(ss);

          for(Employee e : emps)
          {
            payroll.displayGross(e);
            if(e instanceof Manager) //type checking operator
                ((Manager)e).displayAllowance();
          }

    } 
     
}
