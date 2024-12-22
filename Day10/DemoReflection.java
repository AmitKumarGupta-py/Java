package Day10;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.lang.reflect.Parameter;
import java.lang.reflect.Method;

public class DemoReflection {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException
    {
        Student s = new Student();
        Class c = s.getClass();

        Field [] field = c.getDeclaredFields();
        for (Field f : field)
        {
            System.out.println("Field Name : " + f.getName());
            System.out.println("Field Type : " + f.getType());

            if(f.getName().equals("rollno"))
            {
                f.setAccessible(true);
                f.set(s, 110);
                System.out.println("Updated Roll No : " + s.getRollno());
            }
            if(f.getName().equals("name"))
            {
                f.setAccessible(true);
                f.set(s, "sss");
                System.out.println("Updated Name : " + s.getName());
            }

        }
        Constructor [] cons = c.getDeclaredConstructors();
        for(Constructor<T> con : cons)
        {
            System.out.println(con.getParameterCount());
            if(con.getParameterCount() == 2)
            {
                Parameter[] param = con.getParameters();

                System.out.println(Arrays.toString(params));
                Student s1 = (Student) con.newInstance(235,"mmm");
                s1.displayData();

            }
        }

        Method [] methods = c.getDeclaredMethods();
        for(Method m : methods)
        {
            System.out.println("Method Name : " + m.getName());
            if(m.getName().equals("privateMethod"))
            {
                m.setAccessible(true);
                m.invoke(s);
            }
        }

        if(m.getName().equals("staticMethod"))
        {
            m.invoke(null);
        }
        if(m.getName().equals("methodWithParameters"))
        {
            Parameter[] params = m.getParameters();
            System.out.println(Arrays.toString(params));
            m.invoke(s,456,"ttt");
        }
    
}
        for(Method m : methods)
        {
            if(m.getDeclaredAnnotation(CreatedBy.class) != null)
            {
                CreatedBy createdBy = m.getDeclaredAnnotation(CreatedBy.class);
                /*System.out.println("Created By : " + createdBy.name());
                System.out.println("Created On : " + createdBy.date()); */


                if(anno.priority() == 1)
                {
                    m.invoke(s);
                }
            }
        }

}