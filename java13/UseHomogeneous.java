import java.util.Scanner;

public class UseHomogeneous
{
     //Static Method that displays user menu.
    public static void mainMenu()
    {
        System.out.println("1.Push a Student");
        System.out.println("2.Pop a Student");
        System.out.println("3.Peek a Student");
        System.out.println("4.Display/toStirng()");
        System.out.println("5.Exiting the program....");
        System.out.print("Enter your choice : ");
    }
    
    //Method that create a Student object and returns it
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
    
    //Methods that check useability of HomogeneousStack
    public static void useHomogeneousStack()
    {
        int choice = 0;
        
        HomogeneousStack hStack = new HomogeneousStack(20);
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
                choice = 6;
            }
            sc.nextLine();
            
            switch (choice)
            {
                case 1: try
                        {
                            hStack.push(createStudent(sc));
                            System.out.println();
                            mainMenu();
                        }
                        catch(OverflowException ofe)
                        {
                            System.out.println(ofe);
                        }
                        break;

                case 2: try
                        {
                            Student poped = hStack.pop();
                            System.out.println("Poped student :\n" + poped);
                        }
                        catch(UnderflowException ufe)
                        {
                            System.out.println(ufe);
                        }
                        break;

                case 3: try
                        {
                            Student peeked = hStack.peek();
                            System.out.println("Peeked student :\n" + peeked);
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
        useHomogeneousStack();
    }
}