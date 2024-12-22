package Day5;

import java.io.File;
import java.io.IOException;

public class DemoThrow {
        public static void checkFile(String path) throws IOException
        {
            File f = new File(path);
            if(!f.exists())
            {
                throw new IOException("File is not present");
            }
        }
    
    

    public static void main(String[] args) {
        
        try{
            File f = new File("data.txt");
            if(!f.exists())
            {
                throw new IOException("File is not present");
            }
        }
            catch(IOException e)
            {
                System.out.println(e.getMessage());
            }

          /*  try{
                checkFile("abc.txt");

            }
            catch(IOException e)
            {
                e.printStackTrace();
            }  */
        }
    }

