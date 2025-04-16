import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ProcessingNumber
{
    public static void fileInput()
    {
        try
        {
            FileReader file = new FileReader("input1.txt");
            BufferedReader bf = new BufferedReader(file);
            
            int num = 0;
            int count = 0;
            
            String line;
            while(true)
            {
                line = bf.readLine();
                if(line == null)
                {
                    break;
                }
                
                line = line.trim();
                
                int digits = 0;
                
                String[] space = line.split(" ");
                for(int i=0;i<space.length;i++)
                {
                    String[] comma = space[i].split(",");
                    
                    for(int j=0;j<comma.length;j++)
                    {
                        try{
                            num += Integer.parseInt(comma[j]);
                            count++;
                        }
                        catch(NumberFormatException e)
                        {
                            //Do nothing
                        }
                        
                    }
                    
                }
                
            }
            
            System.out.println("Average : " + (float)num/count);
            file.close();
            bf.close();
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("Error, file not found");
        }
        catch(IOException ioe)
        {
            System.out.println("Error, reading file");
        }
        
    }

    public static void main(String[] args)
    {
        fileInput();
    }
}
