import java.util.Scanner;           //importing Scanner class.

public class BinaryDecimal {

    static void binaryToDecimal(long num)           //Method to Change Binary number to Decimal.
    {
        long decimal = 0;
        long mul = 1;
        while(num>0)
        {
            decimal = decimal + mul*(num%10);
            mul = mul*2;
            num = num/10;
        }
        System.out.println("Decimal : "+decimal);
    }
    public static void main(String[] args)          
    {
         Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary number : ");
        long num = sc.nextInt();
        sc.close();

        binaryToDecimal(num);
    }
}
