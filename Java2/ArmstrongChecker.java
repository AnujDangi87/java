import java.util.Scanner;

public class ArmstrongChecker {

    static void armChecker(int arm)
    {
        int output = 0;
        int armCopy = arm, pow = 0;
        while (armCopy > 0)                 //finding how digits are in the given number.
        {
            pow++;
            armCopy /= 10;
        }
        armCopy = arm;
        while (arm>0)
        {
            output = (int)(output + Math.pow(arm%10, pow));             //Adding the digit power of each digit of input into output.
            arm /= 10;
        }
        if (output == armCopy)
            System.out.println("Armstrong number");
        else
            System.out.println("Not a Armstrong number");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number (to be checked for armstrong) : ");
        try
        {
            int arm = sc.nextInt();
            sc.close();

            if (arm < 0)                //Input validation.
            {
                System.out.println("Error input can't be negative. Exiting the program....");
            }
            else
                armChecker(arm);
        }
        catch(Exception e)              //Input validation for charcter.
        {
            System.out.println("Error given input is not a number. Exiting the program....");
        }
        
    }
}
