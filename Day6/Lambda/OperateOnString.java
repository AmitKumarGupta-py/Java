package Lambda;



public class OperateOnString {
    public String operateOnString(StringPredicate p, String s)
    {
        return p.apply(s);
    }


    

    public static void main(String[] args) {
        
        
        OperateOnString os = new OperateOnString();
        String ups = os.operateOnString((s) -> s.toUpperCase(), "string for test case");
        System.out.println(ups);



        
       
       String rs = os.operateOnString((s)-> {
            String rvs = "";
            for (int i =s.length() - 1; i >= 0; i--) {
                rvs+= s.charAt(i);
            }
            return rvs;
 },"String for test case!");
        System.out.println(rs);

/*
 * reverse()
 * {
 * String rvs = "";
            for (int i =s.length() - 1; i >= 0; i--) {
                rvs+= s.charAt(i);
            }
            return rvs;
            }
 * 
 * 
 * 
 */
        /*
         * method reference: 
         * for static methods use classname::methodname
         * for instance method  use obj
         */

        upper = operateOnString(String::toUpperCase,"Lambda");

        reverse = operateOnString(os::reverse,"lambda");
    
}
}