package Day5;
import java.util.*;
import java.util.Map.Entry;




public class EmployeeCollection {

    public List<Employee> initializeEmployeeData()
    {
        List<Employee> emplist = new ArrayList<>();
        Set<String> skills1 = new TreeSet<>();
        skills1.add("Java");
        skills1.add("C++");
        emplist.add(new Employee(567,"aaa",75000,skills1));

        Set<String> skills2 = new TreeSet<>();
        skills2.add("C#");
        skills2.add("C++");
        emplist.add(new Employee(467,"afda",70000,skills2));
       
        Set<String> skills3 = new TreeSet<>();
        skills3.add("JavaScript");
        skills3.add("C");
        emplist.add(new Employee(367,"sss",65000,skills3));
        
        Set<String> skills4 = new TreeSet<>();
        skills4.add("Python");
        skills4.add("C++");
        emplist.add(new Employee(987,"rrr",85000,skills4));
        
        Set<String> skills5 = new TreeSet<>();
        skills5.add("Java");
        skills5.add("Python");
        emplist.add(new Employee(787,"yyy",45000,skills5));
        
        Set<String> skills6 = new TreeSet<>();
        skills6.add("Python");
        skills6.add("C");
        emplist.add(new Employee(437,"hhh",78000,skills6));

        return emplist;
    }

    public void printList(List<Employee> emplist)
    {
        for(Employee e : emplist)
        {
            System.out.println(e);
        }
    }

    public Employee searchEmployee(List<Employee> emplist,int empid)
    {
        for(Employee e: emplist)
        {
            if(e.getEmpid()==empid)
            {
                return e;
            }
        }
        return null;
    }

    public List<Employee> filterEmployees(List<Employee> emplist,String criteria)
    {
        List<Employee> filtered = new ArrayList<>();

        for(Employee e : emplist)
        {
            if(e.getSkillset().contains(criteria))
            {
                filtered.add(e);
            }
        }
        return filtered;
        
    }

    public Map<Integer,Double> salaryMap(List<Employee> emplist)
    {
        Map<Integer,Double> salmap = new TreeMap<>();
        for(Employee e : emplist)
        {
            salmap.put(e.getEmpid(),e.getSalary());
        }

        return salmap;
    }  


    public static void main(String[] args) {
        EmployeeCollection e = new EmployeeCollection();
        List<Employee> emplist = e.initializeEmployeeData();

        e.printList(emplist);

        Employee found = e.searchEmployee(emplist, 243);
        System.out.println("Employee Data: "+ found);

        System.out.println("-------Employees Skilled at java---------");
        List<Employee> byskill = e.filterEmployees(emplist, "java");
        e.printList(byskill);

        System.out.println("--------Employees Salary Mapping ----------");

        Map<Integer,Double> salmap = e.salaryMap(emplist);
        for(Entry<Integer,Double> entry : salmap.entrySet())
        {
            System.out.println(entry.getKey() + "--> " +entry.getValue());
        } 

        System.out.println("--------Sort by Employee Id---------");
        Collections.sort(emplist);
        e.printList(emplist);
        int index = Collections.binarySearch(emplist,new Employee(334,null,0,null));
        System.out.println("Found at index " + index);       
        


        System.out.println("---------Sort by Employee Name---------");
        Collections.sort(emplist,new NameComparator());
        e.printList(emplist);

        index = Collections.binarySearch(emplist,new Employee(0,"sss",0,null), new NameComparator());
        System.out.println("Found at index " + index); 

        System.out.println("-------Sort by Employee Salary----------");
        Collections.sort(emplist,new SalaryComparator());
        e.printList(emplist);


        System.out.println("Minimum salary");
        System.out.println(Collections.min(emplist,new SalaryComparator()));

        System.out.println("Maximum Salary");
        System.out.println(Collections.max(emplist,new SalaryComparator()));

        Collections.reverse(emplist);
        e.printList(emplist);

    }
    
}
