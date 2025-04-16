import java.util.Scanner;
import java.io.*;

public class PackingUnpacking
{
    public static void packing()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter total number of subjects : ");
        int count = sc.nextInt();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream((count+1)*4);
        DataOutputStream dos = new DataOutputStream(baos);
        
        for(int i=0;i<count;i++)
        {
            System.out.print("Enter marks for "+(i+1)+"st Subject : ");
            try
            {
                dos.writeInt(sc.nextInt());
            }
            catch (IOException ioe)
            {
                System.out.println(ioe);
            }
        }
        
        byte[] array = baos.toByteArray();
        int number = 0;
        ByteArrayInputStream bais = new ByteArrayInputStream(array);
        DataInputStream dis = new DataInputStream(bais);
        
        for(int i=0;i<count;i++)
        {
            
            try
            {
                number = dis.readInt();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
            
            System.out.println("Output mark : " + number);
        }
        
    }
    
    public static void main(String[] args)
    {
        packing();
    }
}
