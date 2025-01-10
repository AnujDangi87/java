import java.util.Scanner;

public class Fibonacci {

    static void generateFibonacci(int n)    //Method to generate Fibaonacci by taking no of terms (n).
    {
        int a=0, b=1, c;
        System.out.print("0, 1");          //printing first two two terms.
       while(n>2)
       {
            c = a+b;                
            a = b;
            b = c;
            System.out.print(", "+c);
            n--;
       }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);                //making object sc of Scanner class.

        System.out.print("Enter the no of terms(n) : ");            //taking input from stdin using Scanner class.
        int n = sc.nextInt();
        sc.close();

        if ( n <= 0)                                        //input validation.
        {
            System.out.println("Error, value of n is less than or equal to 0. Exiting the program...");
        }
        else
        {
            generateFibonacci(n);
        }


    }
}
