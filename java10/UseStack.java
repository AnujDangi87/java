import java.util.Scanner;

public class UseStack
{
    //Method that displays main menu
    static void mainMenu()
    {
        System.out.println("1.push");
        System.out.println("2.pop");
        System.out.println("3.peek");
        System.out.println("4.isEmpty");
        System.out.println("5.Display the stack");
        System.out.println("6.Give Stack object as substitution argument(plymorphic method)");
        System.out.println("7.Give ArrayLinearList object as substitution argument(plymorphic method)");
        System.out.println("8.Exit the program....");
        System.out.print("Enter your choice : ");
    }
    
    //Methods to check for priciple of substitution
    public static void get(ArrayLinearList arr, int index)
    {
        if(arr.get(index) != -888)
        {
            System.out.println("Semantics of ArrayLinearList are satisfied");
        }
        else
            System.out.println("Semantics are not satisfied");
    }
    
    //Methods to check for priciple of substitution
    public static void remove(ArrayLinearList arr, int index)
    {
        if(arr.remove(index) != -888)
        {
            System.out.println("Semantics of ArrayLinearList are satisfied");
        }
        else
            System.out.println("Semantics are not satisfied");
    }
    
    //Methods to check for priciple of substitution
    public static void indexOf(ArrayLinearList arr, int element)
    {
        if(arr.indexOf(element) != -888)
        {
            System.out.println("Semantics of ArrayLinearList are satisfied");
        }
        else
            System.out.println("Semantics are not satisfied");
    }
    
    //Method to take input form user
    public static int[] stackInput(Scanner sc)
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
    
    //Method that checks useability of Stack class
    public static void useStack()
    {
        int choice = 0;

        Scanner sc = new Scanner(System.in);
        int[] input = stackInput(sc);
        Stack s = new Stack(input);
        ArrayLinearList all = new ArrayLinearList(input.length, input);
        mainMenu();

        while(choice != 8)
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
                case 1: System.out.print("Enter value : ");
                        //Error handling
                        try
                        {
                            s.push(sc.nextInt());
                            System.out.println("Stack : " + s.toString());
                            sc.nextLine();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                            sc.next();
                        }
                        break;

                case 2: int pop = s.pop();
                        if(pop != -999)
                        {
                            System.out.println("Poped value : " + pop);
                        }
                        break;
                        
                case 3: int peek = s.peek();
                        if(peek != -999)
                        {
                            System.out.println("Top most value : " + peek);
                        }
                        break;
                        
                case 4: System.out.println(s.isEmpty());
                        break;
                        
                case 5: System.out.println("Stack : " + s.toString());
                        break;
                
                case 6 : get(s, 0);
                         remove(s, 0);
                         indexOf(s, 12);
                         break;
                
                case 7:  get(all, 0);
                         remove(all, 0);
                         indexOf(all, 12);
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
    
    public static void main(String[] args){
         useStack();
    }
}
