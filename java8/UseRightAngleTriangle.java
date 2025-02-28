import java.util.Scanner;

public class UseRightAngleTriangle 
{
    static void displayMenu()
    {
        System.out.println("\n1.Display both area and perimeter");
        System.out.println("2.Enter coordinates again");
        System.out.println("3.To exit the program");
        System.out.print("Enter your choice : ");
    }

    static int[][] Input(Scanner sc)
    {
        System.out.print("Enter initial coordinates(x1 y1 x2 y2 x3 y3 space between them) : ");
        String str = sc.nextLine().trim();
        String[] strArr = str.split(" ");
        int[][] arr = new int[3][2];

        int k=0;
        try
        {
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<2;j++)
                {
                    arr[i][j] = Integer.parseInt(strArr[k++]);
                }
                
            }
        }
        catch(Exception e)
        {
            System.out.println("Error : " + e + ".\nWrong input,only integers is allowed. Enter any key to try again");            //Error handling (input validation)
            sc.next();
        }
        return arr;
    }

    //Static Method for checking the useability of RightAngleTriangle class.
    static void useRightAngleTriangle()
    {
        int choice = 0;

        Scanner sc = new Scanner(System.in);

        RightAngleTriangle rat = new RightAngleTriangle(Input(sc));
        displayMenu();

        while(choice != 3)
        {
            try
            {
                choice = sc.nextInt();
                sc.nextLine();
            }
            catch(Exception e)
            {
                System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                sc.next();
            }
            
            switch (choice)
            {
                case 1: System.out.println("Area : "+rat.area() + "\nPerimeter : "+rat.perimeter());
                    break;

                case 2: rat = new RightAngleTriangle(Input(sc));
                        displayMenu();          
                        break;

                case 3: System.out.println("Exiting the program....");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }

            if(choice != 3 && choice != 2)
            {
                System.out.print("\nEnter your choice : ");
            }
        }
        sc.close();
    }
    public static void main(String[] args) {
        useRightAngleTriangle();
    }
}
