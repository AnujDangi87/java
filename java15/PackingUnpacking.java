import java.util.Scanner;
import java.io.*;

public class PackingUnpacking
{
    public static void packing()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter total number of subjects : ");
        int count = sc.nextInt();
        //Creating a output stream to store data
        ByteArrayOutputStream baos = new ByteArrayOutputStream((count+1)*4);
        //DataOutput stream to write in the above output stream
        DataOutputStream dos = new DataOutputStream(baos);
        
        for(int i=0;i<count;i++)
        {
            System.out.print("Enter marks for "+(i+1)+"st Subject : ");
            try
            {
                //Writing to the ByteArrayOutputStream
                dos.writeInt(sc.nextInt());
            }
            catch (IOException ioe)
            {
                System.out.println(ioe);
            }
        }
        
        //Creating a byte array to store the data that is in ByteArrayOutputStream
        byte[] array = baos.toByteArray();
        int number = 0;
        //ByteArayInputStream to store the byte array input
        ByteArrayInputStream bais = new ByteArrayInputStream(array);
        //DataInputStream to read input from ByteArrayInputStream
        DataInputStream dis = new DataInputStream(bais);
        
        for(int i=0;i<count;i++)
        {
            
            try
            {   //Reading from the ByteArrayInputStream
                number = dis.readInt();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
            
            System.out.println("Output mark : " + number);
        }
        
        sc.close();
        try
        {
            baos.close();
            dos.close();
            dis.close();
            bais.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        packing();
    }
}
