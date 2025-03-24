import java.util.Scanner;
public class UseStudent
{
    //Static Method that displays user menu.
    static void mainMenu()
    {
        System.out.println("By default two object of Student is already created if you want to change use option 1&2");
        System.out.println("1.Student 1");
        System.out.println("2.Student 2");
        System.out.println("3.equals()");
        System.out.println("4.toString()");
        System.out.println("5.Exiting the program....");
        System.out.print("Enter your choice : ");
    }
    
    //Method to check useability of Student class
    public static void useStudent()
    {
        int choice = 0;
        
        //Predefinded objects of Student class
        Student s1 = new Student("Anuj", 16, "23MCCE16", new int[]{10, 49, 59});
        Student s2 = new Student("Chandan", 15, "23MCCE15", new int[]{100, 89, 74});
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
                case 1: s1 = studentMenu(s1, sc);
                        break;

                case 2: s2 = studentMenu(s2, sc);
                        break;

                case 3: System.out.println("Is the Student 1 and Student 2 objects are equal : " + s1.equals(s2));
                        break;

                case 4: System.out.println(s1 + "\n\n" + s2);
                        break;

                case 5: System.out.println("Exiting the program....");
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }

            if(choice != 5 && choice != 1 && choice != 2)
            {
                System.out.print("\nEnter your choice : ");
            }
        }
        
        sc.close();
    }
    
    //Menu driven to take input from user for Student object.
    public static void displayMenu()
    {
        System.out.println("\n1.Create new Student");
        System.out.println("2.Display student.");
        System.out.println("3.Go back to main menu");
        System.out.print("Enter your choice : ");
    }
    
    public static Student createStudent(Scanner sc)
    {
        int id = 0;
        String name;
        String regno;
        int[] marks;
        
        System.out.print("Enter name of the student: ");
        name = sc.nextLine();
        
        System.out.print("Enter id of the student : ");
        /*try                         //Input validation
        {
            id = sc.nextInt();
            sc.nextLine();
        }
        catch(Exception e)
        {
            System.out.println(e);
            sc.next();
        }*/
        //will set id = 0 if it encouters an error which is not proper input error handling.
        
        //better way--
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
    
    public static Student studentMenu(Student s, Scanner sc)
    {
        int choice = 0;
        displayMenu();
        
        while(choice != 3)
        {
            try                         //Input validation
            {
                choice = sc.nextInt();
                sc.nextLine();
            }
            catch(Exception e)
            {
                System.out.println(e);
                sc.next();
            }
            
            switch (choice)
            {
                case 1: s = createStudent(sc);
                        break;

                case 2: System.out.println(s);
                        break;

                case 3: System.out.println("--Main Menu--");
                        mainMenu();
                        break;

                default: System.out.println("Error, wrong input. Try again");
                        break;
            }

            if(choice != 3)
            {
                System.out.print("\nEnter your choice : ");
            }
        }
        return s;
    }
    
    public static void main()
    {
        //Menu driven 
        useStudent();
    }
}