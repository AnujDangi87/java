import java.io.*;

public class ProcessingNumber
{
    //Method that take file as input and process it 
    public static void fileInput()
    {
        try
        {
            //Using file reader for reading the file
            FileReader file = new FileReader("input1.txt");
            //BufferReader to read more easily
            BufferedReader bf = new BufferedReader(file);
            
            //Variables to store values of sum and total no of digits
            int num = 0;
            int count = 0;
            
            String line;
            while(true)
            {
                line = bf.readLine();       //Reading a whole line at a time
                if(line == null)        //If end of line comes exit the loop
                {
                    break;
                }
                
                //Removing leading and trailing spaces
                line = line.trim();                
                //Using regular expressin to remove space and comma delimmiters
                String[] string = line.split("[\s,\n]+");
                
                //Converting all numbers into integers
                for(int i=0;i<string.length;i++)
                {
                    try{
                        num += Integer.parseInt(string[i]);
                        count++;
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println(e);
                    }
                }
                
            }
            
            System.out.println("Average : " + (float)num/count);
            file.close();
            bf.close();
        }
        catch(FileNotFoundException fnfe)       //Exception handling if FileReader throws a exception
        {
            System.out.println("Error, file not found");
        }
        catch(IOException ioe)          //Exception when reading the files throws a exception
        {
            System.out.println("Error, reading file");
        }
        
    }

    public static void main(String[] args)
    {
        fileInput();
    }
}
