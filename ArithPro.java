import java.util.Scanner;

public class ArithPro {
    static int generateAP(int a, int d, int n)
    {
        if ( n == 1)
        {
            return a;
        }
        return generateAP(a, d, n-1) + d ;

    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n(no of terms) : ");
        int n = sc.nextInt();
        System.out.print("Enter a(First term) : ");
        int a = sc.nextInt();
        System.out.print("Enter d(difference) : ");
        int d = sc.nextInt();
        sc.close();

        if ( n <= 0)
        {
            System.out.println("Error, value of n is less than or equal to 0. Exiting the program...");
        }
        else
        {
            for (int i=1;i<=n;i++)
            {
                System.out.print(generateAP(a, d, i)+" ");
            }
        }


    }
}
