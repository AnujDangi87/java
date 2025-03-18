import java.util.Scanner;

public class UseSeries
{
    //Method that uses principle of substition(polymorphic method)
    public static void printSeries(Series a, int howmany)
    {
        for (int i=0;i<howmany;i++)
        {
            System.out.println("Next number in Series: "+a.getNext());
        }
    }
    
    //Method to print user driven main menu
    static void mainMenu()
    {
        System.out.println("1.getNext()");
        System.out.println("2.reset");
        System.out.println("3.setStart(int i)");
        System.out.println("4.Print how many times");
        System.out.println("5.Exit the program....");
        System.out.print("Enter your choice : ");
    }
    
    //Method that takes input from user
    public static int[] seriesInput(Scanner sc)
    {
        System.out.print("Enter array (spaces between them) : ");
        String str = sc.nextLine().trim();
        String[] strArr = str.split(" ");
        int[] arr = new int[strArr.length];
        
        try
        {
            for(int i=0;i<arr.length;i++)
            {
                    arr[i] = Integer.parseInt(strArr[i]);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error : " + e + ".\nWrong input,only integers is allowed. Enter any key to try again");            //Error handling (input validation)
            sc.next();
        }
        
        return arr;
    }

    //Method to check useability of FiniteSeries class
    public static void useFiniteSeries()
    {
        int choice = 0;

        Scanner sc = new Scanner(System.in);
        FiniteSeries fs = new FiniteSeries(seriesInput(sc));
        mainMenu();

        while(choice != 5)
        {
            //Error handling
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
                case 1: System.out.println("Next value of array : " + fs.getNext());
                        break;

                case 2: fs.reset();
                        System.out.println("Success");
                        break;
                        
                case 3: System.out.print("Enter new start index : ");
                        //Error handling
                        try
                        {
                            fs.setStart(sc.nextInt());
                            sc.nextLine();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                            sc.next();
                        }
                        break;
                        
                case 4: System.out.println("Enter how many next value you want to print : ");
                        //Error handling
                        try
                        {
                            printSeries(fs, sc.nextInt());
                            sc.nextLine();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                            sc.next();
                        }
                        break;

                case 5: System.out.println("Exiting the program....");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }
            
            if(choice != 5)
            {
                System.out.print("\nEnter your choice : ");
            }
        }
        sc.close();
    }
    
    public static void main(String[] args){
         useFiniteSeries();
    }
}