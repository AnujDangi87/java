import java.util.Scanner;

public class LcmGcdFinder {

    static void lcmGcd(int num1, int num2)
    {
        int output=1;
        for(int j=0;j<num1;j++)
        {
            for(int i=2;i<=num1;i++)
            {
                if (num1%i == 0 && num2%i == 0)
                {
                    output = output*i;
                    num1 /= i;
                    num2 /= i;
                }
            }
        }

        System.out.println("LCM : "+output*num1*num2);
        System.out.println("GCD : "+output);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try
        {
            System.out.print("Enter the first number : ");
            int fi = sc.nextInt();
            System.out.print("Enter the second number : ");
            int se = sc.nextInt();
            sc.close();

            if (fi <= 0 || se <= 0)                //Input validation.
            {
                System.out.println("Error input can't be equal or less than 0. Exiting the program....");
            }
            else
                lcmGcd(fi, se);
        }
        catch(Exception e)              //Input validation for charcter.
        {
            System.out.println("Error given input is not a number. Exiting the program....");
        }
    }
}
