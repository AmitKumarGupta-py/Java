package day3;

import java.util.Arrays;

public class StringOperations {

    public static void CheckString(String s)
        {
            int countL = 0;
            int countU = 0;
            int countSp = 0;

             for(int i = 0;i<s.length();i++)
            {
                    char Char1 = s.charAt(i);
                if(Character.isLowerCase(Char1))
                {
                    countL++;
                }
                else if(Character.isUpperCase(Char1))
                {
                    countU++;

                }
                else
                {
                    countSp++;
                }

            }
            System.out.println("No. of lower case: "+ countL + "\nNo. of Upper case: "+ countU + "\nNo. of Special character: "+ countSp);


        }
            
            public static void ShiftChar(String s,int pos)
            {
                    pos = pos % s.length();
                    
                    
                    String leftPart = s.substring(0, pos);
                    String rightPart = s.substring(pos);
                    
                    System.out.println("String After Left shift by 2 positions: " + rightPart + leftPart);
                }
            


            
            
    public static void main(String[] args) {
        
        String s1 = "secure";
        String s2 = "rescue";
        String s3 = "Hello,World!";
        String s4 = "OKAY";
        
        StringOperations so = new StringOperations();
        

        s1 = s1.replaceAll("\\s+", "").toLowerCase();
        s2 = s2.replaceAll("\\s+", "").toLowerCase();

        
        if (s1.length() != s2.length()) {
            System.out.println("Not A anagram\n");;
        }

        
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        
        System.out.println( "\n\nString is Anagram:  " + Arrays.equals(charArray1, charArray2) + "\n\n");

        so.CheckString(s3);
        so.ShiftChar(s4,2);
    
    }
    
}
