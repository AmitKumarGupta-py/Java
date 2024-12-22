package Day5;

import java.io.IOException;

public class BigNumber {
    
    

    public static void main(String[] args) {
        
        try{
            int a = Integer.parseInt(args[0]);
            if(a>60000)
            {
                throw new IOException("Too Big Number");
            }
        }
            catch(IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

