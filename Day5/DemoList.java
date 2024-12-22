package Day5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoList {
    
    public static void main(String[] args) {
        List lst = new ArrayList<>();
        lst.add(120);
        lst.add("test");
        lst.add(23.4f);
        lst.add(true);

        for(int i=0;i<lst.size();i++)
        {
            System.out.println(lst.get(i));
        }

        lst.remove("test");
        for(Object o : lst)
        {
            System.out.println(o);
        }

        Iterator it = lst.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        for(Object o : lst)
        {
            int i = (Integer) o;
            System.out.println(i++);
        }
    }

}
