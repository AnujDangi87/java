import java.util.Scanner;

public class UseSortedList 
{
    static void displayMenu()
    {
        System.out.println("\n1.Insert");
        System.out.println("2.Delete");
        System.out.println("3.Search for value");
        System.out.println("4.Display List");
        System.out.println("5.To exit the program");
        System.out.print("Enter your choice : ");
    }

    static int[] initialInput(Scanner sc)
    {
        System.out.print("Enter initial array(elements with space between them) : ");
        String str = sc.nextLine().trim();
        String[] strArr = str.split(" ");
        int[] arr = new int[strArr.length];

        try
        {
            for(int i=0;i<strArr.length;i++)
            {
                arr[i] = Integer.parseInt(strArr[i]);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error : " + e + ". Wrong input,only integers is allowed try again");            //Error handling (input validation)
            
        }
        
        return arr;
    }

    //Static Method for checking the useability of SortedList class.
    static void useSortedList()
    {
        int choice = 0;

        Scanner sc = new Scanner(System.in);
        SortedList list = new SortedList(initialInput(sc));
        list.display();

        displayMenu();

        while(choice != 5)
        {
            try
            {
                choice = sc.nextInt();
            }
            catch(Exception e)
            {
                System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                sc.next();
            }
            
            switch (choice)
            {
                case 1: System.out.print("Enter value(int to insert) : ");
                        try                     
                        {
                            list.insert(sc.nextInt());
                            list.display();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                            sc.next();
                        }
                        
                        break;

                case 2: System.out.print("Enter value(int to delete) : ");
                        try                     
                        {
                            list.delete(sc.nextInt());
                            list.display();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                            sc.next();
                        }
                        break;

                case 3: System.out.print("Enter value(int to search) : ");
                        
                        try                     
                        {
                            int index = list.find(sc.nextInt());
                            if(index < 0)
                            {
                                System.out.println("Error, element not found!");
                            }
                            else
                            {
                                System.out.println("Element found at index : " + index);
                            }
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                            sc.next();
                        }                       

                        break;

                case 4: list.display();
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
    public static void main(String[] args) {
        useSortedList();
    }    
}
