import java.util.*;
import java.io.*;

public class ManyExceptions {
    
    public void sayHello(int a) {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        try
        {
            //Array out of bound exception as we not have given string in main argument.
            System.out.println("The third argument is " + args[2]);
        }
        catch(ArrayIndexOutOfBoundsException a)
        {
            System.out.println(a);
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int a;
        while(true)
        {
            try
            {
                //InputMismatchException if user gives any other type data as input in a.
                a  = sc.nextInt();
                break;
            }
            catch(InputMismatchException e)
            {
                System.out.println(e + " Please try again.");
                sc.next();
            }
        }
        
        int b;
        System.out.println("Enter another number");
        while(true)
        {
            try
            {
                 //InputMismatchException if user gives any other type data as input in a.
                b = sc.nextInt();
                break;
            }
            catch(InputMismatchException e)
            {
                System.out.println(e + " Please try again.");
                sc.next();
            }
        }
        
        int c;
        try
        {
            //ArithmeticException if user give 0 as value for b.
            c = a / b;
            System.out.println("The result of the division is " + c);
        }
        catch(ArithmeticException ae)
        {
            System.out.println(ae);
        }
        sc.close();
        
        try
        {
            //Scanner object is closed and we accessing it. It will give IllegalStateException as we are accessing a method
            int d = sc.nextInt();
        }
        catch(IllegalStateException x)
        {
            System.out.println(x);
        }
        
        ManyExceptions me = new ManyExceptions();
        me = null;
        try
        {
            //as we have given me as null and trying to access its method it will give null pointer Exception
            me.sayHello(1);
        }
        catch(NullPointerException npe)
        {
            System.out.println(npe);
        }
        
        try
        {
            //As there is no file named file1.txt it will give FileNotFoundException.
            BufferedReader br = new BufferedReader(new FileReader("file1.txt"));
            String line = br.readLine();
            System.out.println("Read line: " + line);
            
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println(fnfe);
        }
        catch(IOException ioe)
        {
            //As there id no file we can't read it so it will give IOException
            System.out.println(ioe);
        }
        
        int[] arr = new int[5];
        try
        {
            //ArrayIndexOutOfBoundException as we are trying to access index 5 which is not there.
            System.out.println("Element1 : " + arr[3] + "\nElement2 : " + arr[5]);
        }
        catch(ArrayIndexOutOfBoundsException aio)
        {
            System.out.println(aio);
        }

        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader("file1.txt"));
            try
            {
                String data = reader.readLine();
                System.out.println("Read data: " + data);
            }
            catch(IOException ioe)
            {
                System.out.println(ioe);
            }
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println(fnfe);
        }
    }
}