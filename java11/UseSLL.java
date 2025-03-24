import java.util.Scanner;

public class UseSLL {
    
    //Menu driven main menu
    static void mainMenu()
    {
        System.out.println("1.Create Sll object");
        System.out.println("2.Create Sll1 object");
        System.out.println("3.Crete Sll2 object");
        System.out.println("4.Copy sll to sll1");
        System.out.println("5.Copy sll1 to sll2");
        System.out.println("6.Copy sll to sll2");
        System.out.println("7.Equals");
        System.out.println("8.Exit the program....");
        System.out.print("Enter your choice : ");
    }

    //Static Method that displays user menu.
    static void displayMenu()
    {
        System.out.println("\n1.Insert at beginning");
        System.out.println("2.Insert at end");
        System.out.println("3.Delete from beginning");
        System.out.println("4.Delete by value");
        System.out.println("5.Sum of list");
        System.out.println("6.toString");
        System.out.println("7.Go Back to main menu");
        System.out.print("Enter your choice : ");
    }
    
    //Method to check for the equilance property of the overrided equals method of SLL class.
    public static void useEquals(SLL sll, SLL sll1, SLL sll2)
    {
        if(sll.equals(sll))
        {
            System.out.println("Reflexive property is satisfied sll.equals(sll)");
        }
        else
        {
            System.out.println("Reflexive property is not satisfied sll.equals(sll)");
        }
        
        if(sll.equals(sll1) && sll1.equals(sll))
        {
            System.out.println("Symmetric property is satisfied sll.equals(sll1) & sll1.equals(sll)");
        }
        else
        {
            System.out.println("Symmetric property is not satisfied sll.equals(sll1) & sll1.equals(sll)");
        }
        
        if(sll.equals(sll1) && sll1.equals(sll2) && sll.equals(sll2))
        {
            System.out.println("Transitive property is satisfied sll.equals(sll1) & sll1.equals(sll2) & sll.equlas(sll2)");
        }
        else
        {
            System.out.println("Transitive property is not satisfied sll.equals(sll1) & sll1.equals(sll2) & sll.equlas(sll2)");
        }
    }

    //Static Method for checking the useability of SLL class.
    static void useSLL()
    {
        int choice = 0;

        SLL sll = new SLL();
        SLL sll1 = new SLL();
        SLL sll2 = new SLL();
        SLL list;
        Scanner sc = new Scanner(System.in);
        mainMenu();
        
        while(choice != 8)
        {
            choice = sc.nextInt();
            
            switch (choice)
            {
                case 1: list = sll;
                        usesll(list, sc);
                        
                        break;

                case 2: list = sll1;
                        usesll(list, sc);
                        break;

                case 3: list = sll2;
                        usesll(list, sc);
                        break;

                case 4: sll1 = new SLL(sll);
                        System.out.println("Successfully copied");
                        break;

                case 5: sll2 = new SLL(sll1);
                        System.out.println("Successfully copied");
                        break;

                case 6: sll2 = new SLL(sll);
                        System.out.println("Successfully copied");
                        break;
                
                case 7: useEquals(sll, sll1, sll2);
                        break;

                case 8: System.out.println("Exiting the program....");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }

            if(choice != 8)
            {
                System.out.print("\nEnter your choice : ");
            }
        }
        
        sc.close();
    }
    
    //Menu inside the main menu program.
    public static void usesll(SLL list, Scanner sc)
    {
        int choice = 0;
        displayMenu();

        while(choice != 7)
        {
            choice = sc.nextInt();
            
            switch (choice)
            {
                case 1: System.out.print("Enter data(int) : ");
                        try                     
                        {
                            list.insertAtBegin(sc.nextInt());
                            list.display();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                            sc.next();
                        }
                        
                        break;

                case 2: System.out.print("Enter data(int) : ");
                        try                     
                        {
                            list.insertAtEnd(sc.nextInt());
                            list.display();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                            sc.next();
                        }
                        break;

                case 3: if(list.deleteAtBegin() != -1)
                        {
                            list.display();
                        }
                        else
                            System.out.println("Error, list is empty!");                        //Error handling (input validation)

                        break;

                case 4: System.out.print("Enter value(int) : ");
                        try
                        {
                            list.deleteByValue(sc.nextInt());
                            list.display();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error : " + e + ". Wrong input, try again");                     //Error handling (input validation)
                            sc.next();
                        }
                        break;

                case 5: if(list.getSum() != -1)
                            System.out.println("Sum : " + list.getSum());
                        else
                            System.out.println("Error, list is empty!");                        //Error handling (input validation)

                        break;

                case 6: System.out.println(list);
                        break;

                case 7: System.out.println("\n----Main Menu----");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }

            if(choice != 7)
            {
                System.out.print("\nEnter your choice : ");
            }
        }
    }
    public static void main(String[] args) {
        //User driven method.
        useSLL();
    }
}