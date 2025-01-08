import java.util.Scanner;

public class Fibonacci {

    static void generateFibonacci(int n)
    {
        int a=0, b=1, c;
        System.out.print("0, 1, ");
       while(n>2)
       {
            c = a+b;
            a = b;
            b = c;
            System.out.print(c+", ");
            n--;
       }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the no of terms(n) : ");
        int n = sc.nextInt();
        sc.close();

        if ( n <= 0)
        {
            System.out.println("Error, value of n is less than or equal to 0. Exiting the program...");
        }
        else
        {
            generateFibonacci(n);
        }


    }
}
