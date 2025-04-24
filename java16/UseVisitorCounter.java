import java.util.Scanner;

public class UseVisitorCounter
{
    //MainMenu method
    public static void mainMenu()
    {
        System.out.println("\n1. Add visitor");
        System.out.println("2. Count of the visitors");
        System.out.println("3. Display unique visitors");
        System.out.println("4. Exit the program....");
        System.out.print("Enter your choice : ");
    }
    
    //Method to check useability of VisitorCounter
    public static void useVisitorCounter()
    {
        int choice = 0;
        
        Scanner sc = new Scanner(System.in);
        VisitorCounter vs = new VisitorCounter();
        
        while(choice != 4)
        {
            mainMenu();
            try                         //Input validation
            {
                choice = sc.nextInt();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            sc.nextLine();
            
            switch (choice)
            {
                case 1: System.out.print("\nEnter name of the visitor : ");
                        String name = sc.nextLine();
                        System.out.print("Enter Ip address : ");
                        vs.addVisitor(new Visitor(name, sc.nextLine()));
                        break;

                case 2: System.out.println("\nCount of the unique Visitors : " + vs.countUniqueVisitors());
                        break;

                case 3: System.out.println("");
                        vs.displayUniqueVisitors();
                        break;

                case 4: System.out.println("Exiting the program....");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }

        }
        
        sc.close();
    }
    
    public static void main(String[] args)
    {
        useVisitorCounter();
    }
}