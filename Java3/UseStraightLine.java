
/**
 * Write a description of class UseStraightLine here.
 *
 * @author (23MCCE16)
 * @version (26-01-25)
*/
import java.util.Scanner;

class UseStraightLine{
    public static void main(String[] args)
    {
        StraightLine line1 = new StraightLine(2, 3, -5);            //Creating line1 and line2 object form StraightLine class
        StraightLine line2 = new StraightLine(4, 6, -10);

        Scanner sc = new Scanner(System.in);
        int choice;
        do
        {
            System.out.println("Choose Option(will return true/false) : ");
            System.out.println("1. To check for parallel line.");
            System.out.println("2. To check for parpendicular line.");
            System.out.println("3. Is point on the line.");
            System.out.println("4. To exit the program.");
            
            choice = sc.nextInt();
            switch(choice)
            {
                case 1: System.out.println(line1.isParallelWith(line2));
                        break;
                case 2: System.out.println(line1.isPerpendicularWith(line2));
                        break;
                case 3: System.out.print("Enter the value of x and y : ");
                        double x1 = sc.nextDouble();
                        double y1 = sc.nextDouble();
                        System.out.print("Enter the line on which you want to check(1 or 2) : ");
                        int line = sc.nextInt();
                        if(line == 1)
                            System.out.println(line1.isPointOnLine(x1, y1));
                        else if(line == 2)
                            System.out.println(line2.isPointOnLine(x1, y1));
                        break;
                default:break;
            }
        }while(choice != 4);
        sc.close();
    }
}