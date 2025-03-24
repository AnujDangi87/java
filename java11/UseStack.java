import java.util.Scanner;

public class UseStack
{
    //Method that displays main menu
    static void mainMenu()
    {
        System.out.println("Operations will be performed on Stack 1(s1)----");
        System.out.println("1.push");
        System.out.println("2.pop");
        System.out.println("3.peek");
        System.out.println("4.isEmpty");
        System.out.println("5.toString()");
        System.out.println("6.Exit the program....");
        System.out.print("Enter your choice : ");
    }
    
    //Checking the equilance relation property of equal method of Stack and ArrayLinearList class.
    public static void useEquals(Object obj1, Object obj2, Object obj3)
    {
        if(obj1.equals(obj1))
        {
            System.out.println("Reflexive property is satisfied obj1.equals(obj1)");
        }
        else
        {
            System.out.println("Reflexive property is not satisfied obj1.equals(obj1)");
        }
        
        if(obj1.equals(obj2) && obj2.equals(obj1))
        {
            System.out.println("Symmetric property is satisfied obj1.equals(obj2) & obj2.equals(obj1)");
        }
        else
        {
            System.out.println("Symmetric property is not satisfied obj1.equals(obj2) & obj2.equals(obj1)");
        }
        
        if(obj1.equals(obj2) && obj2.equals(obj3) && obj1.equals(obj3))
        {
            System.out.println("Transitive property is satisfied obj1.equals(obj2) & obj2.equals(obj3) & obj1.equlas(obj3)\n");
        }
        else
        {
            System.out.println("Transitive property is not satisfied obj1.equals(obj2) & obj2.equals(obj3) & obj1.equlas(obj3)\n");
        }
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
    
    //Method to check useability of the Stack and ArrayLinearList
    public static void useArrayStack()
    {
        int choice = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Stack 1");
        Stack s1 = new Stack(stackInput(sc));
        System.out.println("toString() : "+ s1+"\n");
        System.out.println("Stack 2");
        Stack s2 = new Stack(stackInput(sc));
        System.out.println("toString() : "+ s2+"\n");
        System.out.println("Stack 3");
        Stack s3 = new Stack(stackInput(sc));
        System.out.println("toString() : "+ s3+"\n");
        System.out.println("Equivalence relation of objects : ");
        useEquals(s1, s2, s3);

        System.out.println("ArrayLinearList 1");
        ArrayLinearList all1 = new ArrayLinearList(stackInput(sc));
        System.out.println("toString() : "+ all1+"\n");
        System.out.println("ArrayLinearList 2");
        ArrayLinearList all2 = new ArrayLinearList(stackInput(sc));
        System.out.println("toString() : "+ all2+"\n");
        System.out.println("ArrayLinearList 3");
        ArrayLinearList all3 = new ArrayLinearList(stackInput(sc));
        System.out.println("toString() : "+ all3+"\n");
        useEquals(all1, all2, all3);
        
        mainMenu();
        
        while(choice != 6)
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
                            s1.push(sc.nextInt());
                            System.out.println("Stack : " + s1.toString());
                            sc.nextLine();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error : " + e + ". Wrong input, try again");            //Error handling (input validation)
                            sc.next();
                        }
                        break;

                case 2: int pop = s1.pop();
                        if(pop != -999)
                        {
                            System.out.println("Poped value : " + pop);
                        }
                        break;
                        
                case 3: int peek = s1.peek();
                        if(peek != -999)
                        {
                            System.out.println("Top most value : " + peek);
                        }
                        break;
                        
                case 4: System.out.println(s1.isEmpty());
                        break;
                        
                case 5: System.out.println(s1);
                        break;

                case 6: System.out.println("Exiting the program....");
                        break;
                    
                default: System.out.println("Error, wrong input. Try again");
                        break;
            }
            
            if(choice != 6)
            {
                System.out.print("\nEnter your choice : ");
            }
        }
        sc.close();
    }
    
    public static void main(String[] args){
        //Menu driven program.
         useArrayStack();
    }
}