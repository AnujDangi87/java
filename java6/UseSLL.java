import java.util.Scanner;

public class UseSLL {

    //Static Method that displays user menu.
    static void displayMenu()
    {
        System.out.println("1.Insert at beginning");
        System.out.println("2.Insert at end");
        System.out.println("3.Delete from beginning");
        System.out.println("4.Delete by value");
        System.out.println("5.Sum of list");
        System.out.println("6.Display List");
        System.out.println("7.To exit the program");
        System.out.print("Enter your choice : ");
    }

    //Static Method for checking the useability of SLL class.
    static void useSll()
    {
        int choice = 0;

        SLL list = new SLL();
        Scanner sc = new Scanner(System.in);

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

                case 6: list.display();
                        break;

                case 7: System.out.println("Exiting the program....");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }

            if(choice != 7)
            {
                System.out.print("\nEnter your choice : ");
            }
        }
        sc.close();
    }
    public static void main(String[] args) {
        useSll();
    }
}
