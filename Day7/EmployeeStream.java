package Day7;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Day5.Employee;

public class EmployeeStream {
    public List<Employee> initializeData()
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

    public static void main(String[] args) {
        
        EmployeeStream e = new EmployeeStream();
        List<Employee> emplist = e.initializeData();
        Stream<Employee> stream = emplist.stream();

        Comparator<Employee> byname = Comparator.comparing(Employee::getName);
        System.out.println("-------Sorting ny name---------");
        stream.sorted(byname).forEach(System.out::println);

        stream = emplist.stream();
        Comparator<Employee> bydept = Comparator.comparing(Employee::getDepartment).thenComparing(byname);
        System.out.println("------Sorting by name for dept---------");
        stream.sorted(bydept).forEach(System.out::println);

        System.out.println("-------------");
        stream = emplist.stream();

        Predicate<Employee> salrange = (emp) -> {
            if(emp.getSalary() >= 50000 && emp.getSalary() < 75000)
                return true;
            else
                return false;};

        stream.filter(salrange).forEach((v) -> System.out.println(v));
        System.out.println("---------filter by skill -----------");
        stream = emplist.stream();
        stream.filter((emp) -> emp.getSkillset().contains("java")).forEach(System.out::println);

        System.out.println("-------------Group by department----------");

        stream = emplist.stream();
        Map<String,List<Employee>> empsbydept = stream.collect(Collectors.groupingBy(Employee::getDepartment));

        empsbydept.forEach((k,v) -> System.out.println(k + "," + v));

        System.out.println("-------------");
        stream = emplist.stream();
        stream.map((emp) -> new Department(emp.getEmpid(),emp.getDepartment()));

        System.out.println("---------------------");
        stream = emplist.stream();
        double totalsal = stream.mapToDouble(Employee::getSalary).reduce(0,(e1,e2) -> e1+e2);
        System.out.println(totalsal);

        }

    }
    

