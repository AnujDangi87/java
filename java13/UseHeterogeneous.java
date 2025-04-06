import java.util.Scanner;

public class UseHeterogeneous
{
     //Static Method that displays user menu.
    public static void mainMenu()
    {
        System.out.println("1.Push a Object");
        System.out.println("2.Pop a Object");
        System.out.println("3.Peek a Object");
        System.out.println("4.Display/toStirng()");
        System.out.println("5.Exiting the program....");
        System.out.print("Enter your choice : ");
    }
    
    //Methods that create Studetn object and returns it
    public static Student createStudent(Scanner sc)
    {
        int id = 0;
        String name;
        String regno;
        int[] marks;
        System.out.print("Enter name of the student: ");
        name = sc.nextLine();
        
        System.out.print("Enter id of the student : ");
    
        while(true)
        {
            if(sc.hasNextInt())
            {
                id = sc.nextInt();
                sc.nextLine();              //For next line character in buffer.
                break;
            }
            else
            {
                System.out.println("Invalid input. Please enter again.");
                System.out.print("Enter id of the student : ");
                sc.next();                      //To remove the value from buffer in case of non-integer.
            }
        }
        
        System.out.print("Enter regno of student : ");
        regno = sc.nextLine();
        
        String[] subjects = {"Java", "Dsa", "It"};
        marks  = new int[subjects.length];
        for(int i=0;i<subjects.length;i++)
        {
            System.out.print("Enter marks for " + subjects[i] + " : ");
            while(true)
            {
                if(sc.hasNextInt())
                {
                    marks[i] = sc.nextInt();
                    sc.nextLine();              //For next line character in buffer.
                    if(marks[i] < 0 || marks[i] > 100)
                    {
                        System.out.println("Invalid input. Please enter again.");
                        System.out.print("Enter marks for " + subjects[i] + " : ");
                        continue;
                    }
                    break;
                }
                else
                {
                    System.out.println("Invalid input. Please enter again.");
                    System.out.print("Enter marks for " + subjects[i] + " : ");
                    sc.next();              //To remove the value in buffer apart form integer
                }
            }
        }
        
        return new Student(name, id, regno, marks);
    }
    
    //Method that returns Integer object and returns it
    public static int createInt(Scanner sc)
    {
        System.out.print("Enter int value : ");
        int n;
        
        while(true)
        {
            if(sc.hasNextInt())
            {
                n = sc.nextInt();
                sc.nextLine();              //For next line character in buffer.
                break;
            }
            else
            {
                System.out.println("Invalid input. Please enter again.");
                System.out.print("Enter int value : ");
                sc.next();                      //To remove the value from buffer in case of non-integer.
            }
        }
        
        return n;
    }
    
    //Method that returns a String object
    public static String createString(Scanner sc)
    {
        System.out.print("Enter String : ");
        String s = sc.nextLine();
        return s;
    }
    
    //User driven input Menu
    public static void inputMenu()
    {
        System.out.println("\n1.Create a int Object");
        System.out.println("2.Create a String Object");
        System.out.println("3.Create a Student Object");
        System.out.println("4.Go back to main menu");
        System.out.print("Enter your Choice : ");
    }
    
    //Method that create Object of Student, Int, String
    public static void createObject(Scanner sc, HeterogeneousStack hStack)
    {
        int choice = 0;
        inputMenu();
        
        while(choice != 4)
        {
            try                         //Input validation
            {
                choice = sc.nextInt();
            }
            catch(Exception e)
            {
                System.out.println(e);
                choice = 5;
            }
            sc.nextLine();
            
            switch (choice)
            {
                case 1: try
                        {
                            hStack.push(createInt(sc));
                            inputMenu();
                        }
                        catch(OverflowException ofe)
                        {
                            System.out.println(ofe);
                        }
                        break;

                case 2: try
                        {
                            hStack.push(createString(sc));
                            inputMenu();
                        }
                        catch(OverflowException ofe)
                        {
                            System.out.println(ofe);
                        }
                        break;

                case 3: try
                        {
                            hStack.push(createStudent(sc));
                            inputMenu();
                        }
                        catch(OverflowException ofe)
                        {
                            System.out.println(ofe);
                        }
                        break;

                case 4: System.out.println("Returning to main menu....");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }
        }
    }
    
    //Method that checks useability of HeterogeneousStack
    public static void useHeterogeneousStack()
    {
        int choice = 0;
        
        HeterogeneousStack hStack = new HeterogeneousStack(20);
        Scanner sc = new Scanner(System.in);
        mainMenu();
        
        while(choice != 5)
        {
            try                         //Input validation
            {
                choice = sc.nextInt();
            }
            catch(Exception e)
            {
                System.out.println(e);
                sc.next();
            }
            
            switch (choice)
            {
                case 1: createObject(sc, hStack);
                        System.out.println();
                        mainMenu();
                        break;

                case 2: try
                        {
                            Object poped = hStack.pop();
                            System.out.print("poped ");
                            if(poped.getClass().getName() == "java.lang.Integer")
                            {
                                System.out.println("Int : " + poped);
                            }
                            else if(poped.getClass().getName() == "java.lang.String")
                            {
                                System.out.println("String : " + poped );
                            }
                            else
                                System.out.println(poped );
                        }
                        catch(UnderflowException ufe)
                        {
                            System.out.println(ufe);
                        }
                        break;

                case 3: try
                        {
                            Object peeked = hStack.peek();
                            System.out.print("Peeked ");
                            if(peeked.getClass().getName() == "java.lang.Integer")
                            {
                                System.out.println("Int : " + peeked);
                            }
                            else if(peeked.getClass().getName() == "java.lang.String")
                            {
                                System.out.println("String : " + peeked );
                            }
                            else
                                System.out.println(peeked );
                        }
                        catch(UnderflowException ufe)
                        {
                            System.out.println(ufe);
                        }
                        break;

                case 4: hStack.display();
                        break;

                case 5: System.out.println("Exiting the program....");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }

            if(choice != 5 && choice != 1)
            {
                System.out.print("\nEnter your choice : ");
            }
        }
        
        sc.close();
    }
    
    public static void main(String[] args)
    {
        useHeterogeneousStack();
    }
}